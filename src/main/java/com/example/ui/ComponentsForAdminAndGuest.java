package com.example.ui;

import com.example.annotations.SecurityAnnotation;
import com.example.types.Role;

@SecurityAnnotation(allowedRole = {Role.ADMIN, Role.GUEST})
public class ComponentsForAdminAndGuest extends UIComponent{
	
	public ComponentsForAdminAndGuest(){
		this.componentName = "Some components for admin and guest";
	}
	
	public static UIComponent getComponent(){
		
		return new ComponentsForAdminAndGuest();
	}
}
