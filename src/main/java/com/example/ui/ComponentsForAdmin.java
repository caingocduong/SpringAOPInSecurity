package com.example.ui;

import com.example.annotations.SecurityAnnotation;
import com.example.types.Role;

@SecurityAnnotation(allowedRole={Role.ADMIN})
public class ComponentsForAdmin extends UIComponent{
	
	public ComponentsForAdmin(){
		this.componentName = "Some components for admin";
	}
	
	public static UIComponent getComponent(){
		
		return new ComponentsForAdmin();
	}
}
