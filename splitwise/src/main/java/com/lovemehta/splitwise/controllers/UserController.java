package com.lovemehta.splitwise.controllers;

import com.lovemehta.splitwise.models.User;
import com.lovemehta.splitwise.services.UserService;

public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public User addUser(int id, String name) {
		return userService.addUser(id, name);
	}
}
