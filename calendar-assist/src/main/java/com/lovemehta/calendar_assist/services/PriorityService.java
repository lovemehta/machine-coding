package com.lovemehta.calendar_assist.services;

import java.util.List;

import com.lovemehta.calendar_assist.enums.Role;
import com.lovemehta.calendar_assist.models.Calendar;
import com.lovemehta.calendar_assist.models.CalendarEvent;

public interface PriorityService {

	public Calendar getCalendarFromUnprocessedEvents(List<CalendarEvent> unprocessedEvents,
			List<Role> rolePriorityOrder);

}
