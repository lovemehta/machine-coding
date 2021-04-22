package com.lovemehta.calendar_assist.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CalendarEvent {

	private Employee employee;

	private String eventName;

	private Date startTime;

	private Date endTime;

	private Integer numOfMembers;

	private Employee organiser;

}
