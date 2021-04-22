package com.lovemehta.calendar_assist.services;

import java.util.ArrayList;
import java.util.List;

import com.lovemehta.calendar_assist.enums.Role;
import com.lovemehta.calendar_assist.models.Calendar;
import com.lovemehta.calendar_assist.models.CalendarEvent;

public class DefaultPriorityService implements PriorityService {

	private CalendarEvent getEventWithHighestPriority(List<CalendarEvent> events, List<Role> rolePriorityOrder) {

		CalendarEvent event1 = events.get(0);
		CalendarEvent event2 = events.get(1);

		if (event1.getOrganiser().getId() == event1.getEmployee().getId()) {
			return event1;
		}
		if (event2.getOrganiser().getId() == event2.getEmployee().getId()) {
			return event2;
		}

		if (event1.getOrganiser().getRole() == event2.getOrganiser().getRole()) {

			return event1.getNumOfMembers() > event2.getNumOfMembers() ? event1 : event2;
		}

		for (Role role : rolePriorityOrder) {
			if (role == event1.getOrganiser().getRole()) {

				return event1;
			}
			if (role == event2.getOrganiser().getRole()) {
				return event2;
			}
		}

		// clause for years of experience as everything else is name

		return event1.getEndTime().getTime() - event1.getStartTime().getTime() > event2.getEndTime().getTime()
				- event2.getStartTime().getTime() ? event2 : event1;

	}

	public Calendar getCalendarFromUnprocessedEvents(List<CalendarEvent> unprocessedEvents, List<Role> rolePriority) {

		for (int i = 0; i < unprocessedEvents.size(); i++) {

			for (int j = i; j < unprocessedEvents.size(); j++) {
				if (checkOverlap(unprocessedEvents.get(i), unprocessedEvents.get(j))) {
					List<CalendarEvent> overlappingEvents = new ArrayList<CalendarEvent>();
					overlappingEvents.add(unprocessedEvents.get(i));
					overlappingEvents.add(unprocessedEvents.get(j));
					CalendarEvent high = getEventWithHighestPriority(overlappingEvents, rolePriority);

					if (high == unprocessedEvents.get(i)) {
						unprocessedEvents.remove(j);
						j--;
					} else {
						unprocessedEvents.remove(i);
						i--;
					}
				}
			}
		}

		return new Calendar(unprocessedEvents.get(0).getEmployee(), unprocessedEvents);
	}

	private boolean checkOverlap(CalendarEvent event1, CalendarEvent event2) {

		if (event1.getStartTime().before(event2.getStartTime()) && event1.getEndTime().after(event2.getEndTime())) {
			return true;
		}
		if (event2.getStartTime().before(event1.getStartTime()) && event2.getEndTime().after(event1.getEndTime())) {
			return true;
		}

		if (event1.getStartTime().before(event2.getStartTime()) && event1.getEndTime().after(event2.getStartTime())) {
			return true;
		}

		if (event2.getStartTime().before(event1.getStartTime()) && event2.getEndTime().after(event1.getStartTime())) {
			return true;
		}
		return false;

	}

}
