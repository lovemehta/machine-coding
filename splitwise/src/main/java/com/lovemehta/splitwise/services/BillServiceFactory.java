package com.lovemehta.splitwise.services;

public class BillServiceFactory {

	public BillService getInstance(String billType) {

		if (billType.equals("normal")) {
			return new BillServiceImpl();
		}
		return new BillServiceImpl();
	}
}
