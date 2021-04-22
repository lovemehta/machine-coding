package com.lovemehta.splitwise.services;

import java.util.List;

import com.lovemehta.splitwise.models.Group;
import com.lovemehta.splitwise.models.User;
import com.lovemehta.splitwise.repositories.GroupRepository;

public class GroupServiceImpl implements GroupService {

	public Group addGroup(int id, String name, List<User> membersList) {
		Group group = new Group(id, name, membersList);
		GroupRepository.groups.putIfAbsent(id, group);
		return group;
	}

}
