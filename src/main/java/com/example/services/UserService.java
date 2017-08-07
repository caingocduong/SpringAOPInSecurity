package com.example.services;

import com.example.entities.User;
import com.example.types.Role;

public interface UserService {
	User getCurrentUser();
	void setCurrentUser(User user);
	Role getUserRole();
}
