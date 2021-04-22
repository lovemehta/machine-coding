package com.lovemehta.calendar_assist.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {

	private Employee employee;

	private List<CalendarEvent> calendar;

}
