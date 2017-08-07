package com.example.ui;

import com.example.annotations.SecurityAnnotation;
import com.example.types.Role;

@SecurityAnnotation(allowedRole={Role.GUEST})
public class ComponentsForGuest extends UIComponent{
	
	public ComponentsForGuest(){
		this.componentName = "Some components for guest";
	}
	
	public static UIComponent getComponent(){
		
		return new ComponentsForGuest();
	}
}
