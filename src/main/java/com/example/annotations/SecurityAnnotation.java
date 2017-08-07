package com.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.example.types.Role;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityAnnotation {
	Role[] allowedRole();
}
