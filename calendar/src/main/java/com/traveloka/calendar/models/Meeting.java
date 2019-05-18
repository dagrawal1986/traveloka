package com.traveloka.calendar.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Meeting {
	int meetingId;
	String startTime, endTime;
	List<String> attendees;
	Random r = new Random();
	
	public Meeting() {
		meetingId = r.nextInt(1000);
		attendees = new ArrayList<String>();
	}
	
	public int getMeetingId() {
		return meetingId;
	}

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<String> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<String> attendeeslist) {
		this.attendees = attendeeslist;
	}
	
	public void setAttendees(String attendeesstr) {
		String[] attendeelist = attendeesstr.split(" ");
		for(String attendee: attendeelist) {
			attendees.add(attendee);
		}
	}
	
}
