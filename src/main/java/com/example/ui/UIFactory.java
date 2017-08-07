package com.example.ui;

public interface UIFactory {
	UIComponent createComponent(Class<? extends UIComponent> componentClass) throws Exception;
}
