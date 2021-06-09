package com.ss.jb.five.Assignment_5_1;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasDate {
	public LambdasDate() {
		// Lambdas
		String[] array = { "test", "a", "tomorrow", "also", "be" };
		System.out.println(Arrays.toString(array));

		// Length
		Arrays.sort(array, (x, y) -> x.length() - y.length());
		System.out.println(Arrays.toString(array));

		// Reverse length
		Arrays.sort(array, (x, y) -> y.length() - x.length());
		System.out.println(Arrays.toString(array));

		// Alphabetically by first character
		Arrays.sort(array, (x, y) -> x.charAt(0) - y.charAt(0));
		System.out.println(Arrays.toString(array));

		// Containing 'e' before everything else
		Arrays.sort(array, (x, y) -> {
			if (x.contains("e") && !y.contains("e")) {
				return -1;
			}
			return 1;
		});
		System.out.println(Arrays.toString(array));

		// Re-scramble
		Arrays.sort(array, (x, y) -> x.charAt(0) - y.charAt(0));
		
		// Static helper
		Arrays.sort(array, (x, y) -> LambdasDate.eSort(x, y));
		System.out.println(Arrays.toString(array));

		// method that returns a comma separated string based on a given list of
		// integers. Each element should be preceded by the letter 'e' if the number is
		// even, and preceded by the letter 'o' if the number is odd
		System.out.println(toEOString(List.of(1, 2, 3)));

		// Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters
		System.out.println(Arrays.toString(threeAList(List.of("add", "some", "blu", "above")).toArray()));

		
		// Date and Time
		// 1. Which class would you use to store your birthday in years, months, days,
		// seconds, and nanoseconds?
		LocalDateTime time = LocalDateTime.of(LocalDate.of(1996, Month.JULY, 24), LocalTime.now());

		// 2. Given a random date, how would you find the date of the previous Thursday?
		time.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));

		// 3. What is the difference between a ZoneId and a ZoneOffset?
		// ZoneOffset is the absolute offset whereas ZoneId contains rules for how the
		// offset varies

		// 4. How would you convert an Instant to a ZonedDateTime? How would you convert
		// a ZonedDateTime to an Instant?
		ZonedDateTime zonedTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		Instant inst = ZonedDateTime.now().toInstant();

		// 5. Write an example that, for a given year, reports the length of each month
		// within that year.
		printMonthLengths(2021);

		// 6. Write an example that, for a given month of the current year, lists all of
		// the Mondays in that month.
		printMondays(Month.JULY);

		// 7. Write an example that tests whether a given date occurs on Friday the
		// 13th.
		fridayTheThirteenth(2020, 11, 13);
		fridayTheThirteenth(2021, 6, 4);
		fridayTheThirteenth(2021, 6, 7);
	}

	private static int eSort(String x, String y) {
		if (x.contains("e") && !y.contains("e")) {
			return -1;
		}
		return 1;
	}

	// Method to change list to string with even and odd signifiers
	private static String toEOString(List<Integer> list) {
		return list.stream().map(x -> {
			if (x % 2 == 0) {
				return "e" + x.toString();
			}
			return "o" + x.toString();
		}).collect(Collectors.joining(","));
	}

	// Method to return only elements starting with a and 3 letters long
	private static List<String> threeAList(List<String> list) {
		return list.stream().filter(x -> {
			if (x.substring(0, 1).equals("a")) {
				if (x.length() == 3) {
					return true;
				}
			}
			return false;
		}).collect(Collectors.toList());
	}

	// Method to print all Month lengths
	private static void printMonthLengths(int year) {
		System.out.println("The length of months in " + year + " are:");
		for (Month month : Month.values()) {
			YearMonth temp = YearMonth.of(year, month);
			System.out.println(month + ": " + temp.lengthOfMonth() + " days");
		}
	}

	// Method to print all Mondays
	private static void printMondays(Month month) {
		System.out.println("Mondays in the month of " + month);
		LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month temp = date.getMonth();
		while (temp == month) {
			System.out.println(date);
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			temp = date.getMonth();
		}
	}

	// Method for finding if a day is Friday the 13th
	private static void fridayTheThirteenth(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		if (date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13) {
			System.out.println(date.toString() + " is a Friday the 13th");
		} else {
			System.out.println(date.toString() + " is not a Friday the 13th");
		}
	}
}