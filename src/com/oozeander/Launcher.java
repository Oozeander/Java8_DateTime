package com.oozeander;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Launcher {
	public static void main(String[] args) {
		// LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTime : " + dateTime);
		// toLocalDate/Time
		System.out.println(dateTime.toLocalDate() + " - " + dateTime.toLocalTime());
		// getMonth / hours / year / ...
		System.out.println(dateTime.getDayOfMonth() + " " + dateTime.getMonth() + " " + dateTime.getYear());
		// Create LocalDate/Time of/parse
		LocalDate date = LocalDate.of(1996, Month.SEPTEMBER, 9);
		LocalTime time = LocalTime.parse("03:45:27");
		System.out.println(date + " - " + time);
		// Add/Remove Time
		LocalDateTime minus = LocalDateTime.now().minus(7, ChronoUnit.MINUTES),
				plus = LocalDateTime.now().plus(30, ChronoUnit.DAYS);
		System.out.println(minus + "\n" + plus);
		// After/Before
		System.out.println(minus.isBefore(plus));
		// Time between dates/times
		long minutes = ChronoUnit.MINUTES.between(minus, plus);
		long days = ChronoUnit.DAYS.between(date, date.plus(2, ChronoUnit.MONTHS));
		System.out.println("minutes : " + minutes + "\n" + "days : " + days);
		// TimeZone
		LocalDateTime tz = LocalDateTime.now(ZoneId.of("Europe/Paris"));
		ZonedDateTime dateTimeWithTz = ZonedDateTime.of(dateTime, ZoneId.of("UTC")); // Europe/Paris
		System.out.println(tz + "\n" + dateTimeWithTz);
		// DateTime to str
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm Z z");
		System.out.println(dateTimeWithTz.format(formatter));
		// str to DateTime
		System.out.println(ZonedDateTime.parse(dateTimeWithTz.format(formatter), formatter));
	}
}