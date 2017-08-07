package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.services.UserService;
import com.example.services.UserServiceImpl;
import com.example.ui.UIFactory;
import com.example.ui.UIFactoryImpl;

@Configuration
public class AppConfig {
	@Bean
	public UIFactory uiFactory(){
		
		return new UIFactoryImpl();
	}
	
	@Bean
	public UserService userService(){
		
		return new UserServiceImpl();
	}
}
