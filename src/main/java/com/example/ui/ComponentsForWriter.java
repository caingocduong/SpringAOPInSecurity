package com.example.ui;

import com.example.annotations.SecurityAnnotation;
import com.example.types.Role;

@SecurityAnnotation(allowedRole={Role.WRITER})
public class ComponentsForWriter extends UIComponent{
	public ComponentsForWriter(){
		this.componentName = "Some components for writer";
	}
	
	public static UIComponent getComponent(){
		
		return new ComponentsForWriter();
	}
}
