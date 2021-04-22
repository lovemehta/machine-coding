package com.lovemehta.calendar_assist.models;

import com.lovemehta.calendar_assist.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer id;
	private String name;
	private Role role;

	// years of experience

}
