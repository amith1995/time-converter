package com.amith.utils;

public class Time {

	private final int hour;
	private final int minute;

	public Time(int hour, int minute) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("Hour must be 0-23");
		}
		if (minute < 0 || minute > 59) {
			throw new IllegalArgumentException("Minute must be 0-59");
		}
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}
}
