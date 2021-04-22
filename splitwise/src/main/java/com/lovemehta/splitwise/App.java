package com.lovemehta.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lovemehta.splitwise.controllers.BillController;
import com.lovemehta.splitwise.controllers.GroupController;
import com.lovemehta.splitwise.controllers.UserController;
import com.lovemehta.splitwise.models.Group;
import com.lovemehta.splitwise.models.User;
import com.lovemehta.splitwise.services.BillServiceFactory;
import com.lovemehta.splitwise.services.GroupService;
import com.lovemehta.splitwise.services.GroupServiceImpl;
import com.lovemehta.splitwise.services.UserService;
import com.lovemehta.splitwise.services.UserServiceImpl;

public class App {
	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();

		UserController userController = new UserController(userService);

		BillServiceFactory billServiceFactory = new BillServiceFactory();

		BillController billController = new BillController(billServiceFactory.getInstance("normal"));

		GroupService groupService = new GroupServiceImpl();

		GroupController groupController = new GroupController(groupService);

		User love = userController.addUser(0, "Love");

		User harshit = userController.addUser(1, "Harshit");

		User anju = userController.addUser(2, "Anju");

		List<User> membersList = new ArrayList<User>();

		membersList.add(love);
		membersList.add(harshit);
		membersList.add(anju);

		Group group = groupController.addGroup(0, "home", membersList);

		HashMap<Integer, Integer> paidByHashMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> contributionHashMap = new HashMap<Integer, Integer>();

		paidByHashMap.put(0, 100);

		paidByHashMap.put(1, 0);

		paidByHashMap.put(2, 0);

		contributionHashMap.put(0, 34);
		contributionHashMap.put(1, 33);
		contributionHashMap.put(2, 33);

		billController.addBill(0, group.getId(), 100, contributionHashMap, paidByHashMap);

		System.out.println(billController.getUserBalance(2));
	}
}
