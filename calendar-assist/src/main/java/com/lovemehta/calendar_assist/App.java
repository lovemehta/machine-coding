package com.lovemehta.calendar_assist;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ParseException {

		Thread thread = new Thread();
		
		thread.start();

		//
//		int[] arr = { 4, 1, 8, 6, 2, 3, 10, 1, 6, 6 };
//		int n = 10;
//		int k = 5;
//		int sum = 0;
//
//		for (int i = 0; i < n; i++) {
//			sum += arr[i];
//		}
//
//		double avg = sum / n;
//
//		int hasAvg = 0;
//		for (int i = 0; i < n; i++) {
//			
//			System.out.println(arr[i]+" "+ avg);
//
//			if (arr[i] < avg) {
//				arr[i] += k;
//			} else if (arr[i] > avg) {
//				arr[i] -= k;
//			} else {
//				hasAvg = 1;
//			}
//		}
//		System.out.println(hasAvg);
//		System.out.println(Arrays.toString(arr));
//
//		Arrays.sort(arr);
//
//		int res = arr[n - 1] - arr[0];
//
//		if (hasAvg == 1) {
//			if (avg + k - arr[0] < res) {
//				res = (int) avg + k - arr[0];
//			}
//			if (arr[n - 1] - (avg - k) < res) {
//				res = arr[n - 1] - ((int) avg - k);
//			}
//		}
//
//		System.out.println(res);

//
//		Employee nitish = new Employee(0, "NITISH", Role.MANAGER);
//		Employee amit = new Employee(1, "Amit", Role.DIRECTOR);
//		Employee sachin = new Employee(2, "Sachin", Role.DIRECTOR);
//		Employee sushma = new Employee(3, "Sushma", Role.MANAGER);
//		Employee john = new Employee(4, "John", Role.DIRECTOR);
//		Employee kanhaiya = new Employee(5, "KANHAIYA", Role.COO);
//		Employee girish = new Employee(6, "Girish", Role.DIRECTOR);
//		Employee kalyan = new Employee(7, "Kalyan", Role.CEO);
//		Employee iravati = new Employee(8, "Iravati", Role.MANAGER);
//		Employee harish = new Employee(9, "Harish", Role.MANAGER);
//
//		EmployeeRepo employeeRepo = new EmployeeRepo();
//
//		EmployeeRepo.employeeMap.put(nitish.getId(), nitish);
//		EmployeeRepo.employeeMap.put(amit.getId(), amit);
//		EmployeeRepo.employeeMap.put(sachin.getId(), sachin);
//		EmployeeRepo.employeeMap.put(sushma.getId(), sushma);
//		EmployeeRepo.employeeMap.put(john.getId(), john);
//		EmployeeRepo.employeeMap.put(kanhaiya.getId(), kanhaiya);
//		EmployeeRepo.employeeMap.put(girish.getId(), girish);
//		EmployeeRepo.employeeMap.put(kalyan.getId(), kalyan);
//		EmployeeRepo.employeeMap.put(iravati.getId(), iravati);
//		EmployeeRepo.employeeMap.put(harish.getId(), harish);
//
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//		CalendarEvent event1 = new CalendarEvent(EmployeeRepo.getEmployeeByName("Amit"), "Scrum",
//				formatter.parse("08-4-2021 10:15:00"), formatter.parse("08-4-2021 11:59:00"), 7,
//				EmployeeRepo.getEmployeeByName("NITISH"));
//		CalendarEvent event2 = new CalendarEvent(EmployeeRepo.getEmployeeByName("Amit"), "OKR Review",
//				formatter.parse("08-4-2021 15:00:00"), formatter.parse("08-4-2021 17:00:00"), 4,
//				EmployeeRepo.getEmployeeByName("KANHAIYA"));
//		CalendarEvent event3 = new CalendarEvent(EmployeeRepo.getEmployeeByName("Amit"), "Design Review",
//				formatter.parse("08-4-2021 17:00:00"), formatter.parse("08-4-2021 18:00:00"), 6,
//				EmployeeRepo.getEmployeeByName("Iravati"));
//		CalendarEvent event4 = new CalendarEvent(EmployeeRepo.getEmployeeByName("Amit"), "Design Discussion",
//				formatter.parse("08-4-2021 11:45:00"), formatter.parse("08-4-2021 13:30:00"), 6,
//				EmployeeRepo.getEmployeeByName("Amit"));
//		CalendarEvent event5 = new CalendarEvent(EmployeeRepo.getEmployeeByName("Amit"), "Team Meeting",
//				formatter.parse("08-4-2021 17:30:00"), formatter.parse("08-4-2021 18:00:00"), 4,
//				EmployeeRepo.getEmployeeByName("John"));
//
//		List<CalendarEvent> unprocessedEvents = new ArrayList<CalendarEvent>();
//		List<Role> rolePriorityList = new ArrayList<Role>();
//
//		rolePriorityList.add(Role.CEO);
//		rolePriorityList.add(Role.COO);
//		rolePriorityList.add(Role.DIRECTOR);
//		rolePriorityList.add(Role.MANAGER);
//
//		unprocessedEvents.add(event1);
//		unprocessedEvents.add(event2);
//		unprocessedEvents.add(event3);
//		unprocessedEvents.add(event4);
//		unprocessedEvents.add(event5);
//
//		PriorityService priorityService = new DefaultPriorityService();
//
//		Calendar calendar = priorityService.getCalendarFromUnprocessedEvents(unprocessedEvents, rolePriorityList);
//
//		System.out.println(calendar.getEmployee().getName());
//
//		for (CalendarEvent event : calendar.getCalendar()) {
//
//			System.out.println(event.getEventName() + " , " + event.getStartTime() + " , " + event.getEndTime() + " , "
//					+ event.getNumOfMembers() + " , " + event.getOrganiser().getName());
//
//		}

	}
}
