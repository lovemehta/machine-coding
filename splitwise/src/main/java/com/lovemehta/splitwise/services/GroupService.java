package com.lovemehta.splitwise.services;

import java.util.List;

import com.lovemehta.splitwise.models.Group;
import com.lovemehta.splitwise.models.User;

public interface GroupService {

	public Group addGroup(int id, String name, List<User> membersList);

}
