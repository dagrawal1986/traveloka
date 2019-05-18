package com.traveloka.calendar.factory;

import com.traveloka.calendar.models.Employee;

public class EmployeeFactory {
		
	public static Employee createEmployee(String employeeId) {
		return new Employee(employeeId);
	}
}
