package com.traveloka.calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.traveloka.calendar.models.Employee;
import com.traveloka.calendar.models.Meeting;

public class Calendar implements ICalendar{
	Map<String, Employee> employeeMap;
	Map<Integer, Meeting> meetingMap;
	
	public Calendar() {
		employeeMap = new HashMap<String, Employee>();
		meetingMap = new HashMap<Integer, Meeting>();
	}
	
	public void addEmployee(Employee employee) {
		if(employee == null) return;
		employeeMap.put(employee.getEmployeeId(), employee);
	}
	
	public void addMeeting(Meeting meeting) {
		meetingMap.put(meeting.getMeetingId(), meeting);
		List<String> attendees = meeting.getAttendees();
		for(String employeeId: attendees) {
			Employee e = employeeMap.get(employeeId);
			if(e != null)
				e.addMeeting(meeting.getMeetingId());
		}
	}
	
	public void printMeeting(String employeeId) {
		Employee e = employeeMap.get(employeeId);
		if(e != null)
			e.printMeetings();
	}
	
	public int minRoom() {
		
		List<String> startTime = new ArrayList<String>();
		List<String> endTime = new ArrayList<String>();
		
		for(Map.Entry<Integer, Meeting> entry: meetingMap.entrySet()) {
			Meeting m = entry.getValue();
			startTime.add(m.getStartTime());
			endTime.add(m.getEndTime());
		}
		Comparator comparator = new Comparator<String>() {
			public int compare(String o1, String o2) {
				int t1 = Integer.parseInt(o1);
				int t2 = Integer.parseInt(o2);
				return t1-t2;
			}	
		};
		
		Collections.sort(startTime, comparator);
		Collections.sort(endTime, comparator);
		int index1 = 0, index2 = 0;
		int roomRequired = 0, maxRoom = Integer.MIN_VALUE;
		while(index1 < startTime.size() && index2 < endTime.size()) {
			if(startTime.get(index1).compareTo(endTime.get(index2)) < 0) {
				roomRequired++;
				maxRoom = Math.max(maxRoom, roomRequired);
				index1++;
			}
			else {
				roomRequired--;
				index2++;
			}
		}
		return maxRoom;
	}
}
