package com.example.services;

import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.types.Role;

@Service
public class UserServiceImpl implements UserService{
	private User user;
	
	@Override
	public User getCurrentUser() {
		
		return user;
	}

	@Override
	public void setCurrentUser(User user) {
		this.user = user;
	}

	@Override
	public Role getUserRole() {
		if(user == null){
			
			return null;
		}
		
		return user.getRole();
	}

}
