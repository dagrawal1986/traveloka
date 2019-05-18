package com.traveloka.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.traveloka.calendar.factory.CalendarFactory;
import com.traveloka.calendar.factory.EmployeeFactory;
import com.traveloka.calendar.factory.MeetingFactory;
import com.traveloka.calendar.models.Employee;
import com.traveloka.calendar.models.Meeting;

/**
 * Hello world!
 *
 */
public class App 
{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
	ICalendar calendar = CalendarFactory.createCalendar();
	
	private void addEmployee() throws IOException {
		System.out.println("add employee");
		System.out.println("enter employee id");
		
		String employeeId = reader.readLine();
		System.out.println("entered employeeId is:" + employeeId);
		Employee employee = EmployeeFactory.createEmployee(employeeId);
		calendar.addEmployee(employee);
	}
	
	private void addMeeting() throws IOException {
		System.out.println("create invite");
		System.out.println("enter start time");
		String startTime = reader.readLine();
		System.out.println("enter end time");
		String endTime = reader.readLine();
		System.out.println("enter attendeeIds separated by space");
		String attendees = reader.readLine();
		
		Meeting meeting = MeetingFactory.createMeeting();
		meeting.setStartTime(startTime);
		meeting.setEndTime(endTime);
		meeting.setAttendees(attendees);
		calendar.addMeeting(meeting);
	}
	
	private void listMeetings() throws IOException {
		System.out.println("list all meeting");
		System.out.println("Enter employeeId:");
		String _employeeId = reader.readLine();
		calendar.printMeeting(_employeeId);
	}
	
	private void minRoom() {
		int room = calendar.minRoom();
		System.out.println("minimum room required is: " + room);
	}
	
	public void start() throws NumberFormatException, IOException{
        while(true) {
        		System.out.println("Enter an option:");
        		int inputval = Integer.parseInt(reader.readLine()); 
        		switch(inputval) {
        			case 1:
        				addEmployee();
        				break;
        			case 2:
        				addMeeting();
        				break;
        			case 3: 
        				listMeetings();
        				break;	
        			case 4:
        				minRoom();
        			default:
        				break;
        		}
        		if(inputval == 9)
        			break;
        }
	}
	
	public static void main( String[] args ) throws NumberFormatException, IOException 
    {
		App app = new App();
		app.start();
    }
 
}
