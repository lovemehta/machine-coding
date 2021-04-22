package com.lovemehta.splitwise.services;

import java.util.HashMap;

import com.lovemehta.splitwise.models.Bill;

public interface BillService {

	public Bill addBill(int id, int groupId, int amount, HashMap<Integer, Integer> contribution,
			HashMap<Integer, Integer> paidBy);

	public HashMap<Integer, Bill> getAllBills();
}
