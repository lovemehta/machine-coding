package com.lovemehta.splitwise.controllers;

import java.util.HashMap;

import com.lovemehta.splitwise.models.Bill;
import com.lovemehta.splitwise.services.BillService;

public class BillController {

	private BillService billService;

	public BillController(BillService billService) {
		this.billService = billService;
	}

	public Bill addBill(int id, int groupId, int amount, HashMap<Integer, Integer> contribution,
			HashMap<Integer, Integer> paidBy) {
		return billService.addBill(id, groupId, amount, contribution, paidBy);
	}

	public int getUserBalance(int userId) {

		int balance = 0;

		for (Bill bill : billService.getAllBills().values()) {
			if (bill.getContribution().containsKey(userId)) {
				balance = balance - bill.getContribution().get(userId);
			}
			if (bill.getPaidBy().containsKey(userId)) {
				balance = balance + bill.getPaidBy().get(userId);
			}
		}
		return balance;

	}
}
