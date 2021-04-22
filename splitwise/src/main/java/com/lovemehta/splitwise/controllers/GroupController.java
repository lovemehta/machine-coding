package com.lovemehta.splitwise.controllers;

import java.util.List;

import com.lovemehta.splitwise.models.Group;
import com.lovemehta.splitwise.models.User;
import com.lovemehta.splitwise.services.GroupService;

public class GroupController {

	private GroupService groupService;

	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	public Group addGroup(int id, String name, List<User> members) {
		return groupService.addGroup(id, name, members);
	}
}
