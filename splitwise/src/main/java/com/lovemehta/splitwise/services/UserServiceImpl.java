package com.lovemehta.splitwise.services;

import com.lovemehta.splitwise.models.User;
import com.lovemehta.splitwise.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	public User addUser(int id, String name) {
		User user = new User(id, name);

		UserRepository.users.putIfAbsent(id, user);
		return user;
	}

}
