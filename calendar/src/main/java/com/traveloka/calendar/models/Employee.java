package com.traveloka.calendar.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	String employeeId;
	List<Integer> meetingList;

	
	public Employee(String employeeId) {
		this.employeeId = employeeId;
		meetingList = new ArrayList<Integer>();
	}
	
	public void addMeeting(int meetingId) {
		meetingList.add(meetingId);
	}
	
	public void printMeetings() {
		for(int meetingId: meetingList) {
			System.out.print(meetingId + " ");
		}
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
