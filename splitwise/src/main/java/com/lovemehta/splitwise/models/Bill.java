package com.lovemehta.splitwise.models;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

	private int id;
	private int groupId;
	private int amount;
	private HashMap<Integer, Integer> contribution;
	private HashMap<Integer, Integer> paidBy;

}
