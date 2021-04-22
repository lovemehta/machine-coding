package com.lovemehta.calendar_assist.repository;

import java.util.HashMap;

import com.lovemehta.calendar_assist.models.Employee;

public class EmployeeRepo {

	public static HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

	public static Employee getEmployeeByName(String string) {

		for (Employee employee : employeeMap.values()) {

			if (employee.getName().equals(string)) {
				return employee;
			}
		}

		return null;
	}

}
