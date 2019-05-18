package com.traveloka.calendar.factory;

import com.traveloka.calendar.Calendar;
import com.traveloka.calendar.ICalendar;

public class CalendarFactory {
	public static ICalendar createCalendar() {
		return new Calendar();
	}
}
