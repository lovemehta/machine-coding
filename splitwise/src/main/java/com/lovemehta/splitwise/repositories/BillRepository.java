package com.lovemehta.splitwise.repositories;

import java.util.HashMap;

import com.lovemehta.splitwise.models.Bill;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillRepository {

	public static HashMap<Integer, Bill> bills = new HashMap<Integer, Bill>();

}
