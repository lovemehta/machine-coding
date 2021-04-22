package com.lovemehta.splitwise.services;

import java.util.HashMap;

import com.lovemehta.splitwise.models.Bill;
import com.lovemehta.splitwise.repositories.BillRepository;

public class BillServiceImpl implements BillService {

	public Bill addBill(int id, int groupId, int amount, HashMap<Integer, Integer> contribution,
			HashMap<Integer, Integer> paidBy) {

		Bill bill = new Bill(id, groupId, amount, contribution, paidBy);

		BillRepository.bills.putIfAbsent(id, bill);

		return bill;
	}

	public HashMap<Integer, Bill> getAllBills() {

		return BillRepository.bills;
	}

}
