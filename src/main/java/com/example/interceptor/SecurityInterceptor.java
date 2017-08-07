package com.example.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.annotations.SecurityAnnotation;
import com.example.services.UserService;
import com.example.types.Role;
import com.example.ui.UIComponent;

@Aspect
@Component
public class SecurityInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	@Autowired
	UserService userService;
	
	@Pointcut("execution(* com.example.ui.UIFactoryImpl.createComponent(..))")
	private void getComponent(){

	}
	
	@Around("getComponent()")
	public UIComponent checkSecurity(ProceedingJoinPoint thisJoinPoint) throws Throwable{
		logger.info("Intercepting creation of a component");
		
		Object[] arguments = thisJoinPoint.getArgs();
		if(arguments.length == 0){
			
			return null;
		}
		
		Annotation annotation = checkTheAnnotation(arguments);
		boolean securityAnnotationPresent = (annotation != null);
		
		if(securityAnnotationPresent){
			boolean userHasRole = verifyRole(annotation);
			if(!userHasRole){
				logger.info("Current user doesn't have permission to have this component created.");
				
				return null;
			}
		}
		
		logger.info("Current user has requied premission for creating a component");
		
		return (UIComponent) thisJoinPoint.proceed();
	}
	
	private Annotation checkTheAnnotation(Object[] arguments){
		Object concreteClass = arguments[0];
		logger.info("Argument's class - [{}]", new Object[] {arguments});
		AnnotatedElement annotatedElement = (AnnotatedElement) concreteClass;
		Annotation annotation = annotatedElement.getAnnotation(SecurityAnnotation.class);
		logger.info("Annotation present - [{}]", new Object[] {annotation});
		
		return annotation;
	}
	
	private boolean verifyRole(Annotation annotation){
		logger.info("Security annotation is present so checking if the user can use it.");
		SecurityAnnotation annotationRole = (SecurityAnnotation) annotation;
		List<Role> requiredRoleList = Arrays.asList(annotationRole.allowedRole());
		Role role = userService.getUserRole();
		
		return requiredRoleList.contains(role);
	}
}
