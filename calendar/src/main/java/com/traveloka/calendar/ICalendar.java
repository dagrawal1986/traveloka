package com.traveloka.calendar;

import com.traveloka.calendar.models.Employee;
import com.traveloka.calendar.models.Meeting;

public interface ICalendar {
	public void addEmployee(Employee employee) ;
	public void addMeeting(Meeting meeting);
	public void printMeeting(String employeeId);
	public int minRoom();
}
