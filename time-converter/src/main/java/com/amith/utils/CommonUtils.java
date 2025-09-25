package com.amith.utils;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amith.constants.TimeConstants;

public class CommonUtils {
	
	private static final Logger LOG = LogManager.getLogger(CommonUtils.class);
	
	private static final Pattern TIME_PATTERN = Pattern.compile("^([0-2][0-9]):([0-5][0-9])$");
	
	public static boolean isNullOrEmpty(String inputString) {
		return null == inputString ? true : inputString.isEmpty();
	}
	
	
	public static String to12HourWord(int hour24) {
		if (hour24 < 0 || hour24 > 24) {
			throw new IllegalArgumentException("Hour Number must be between 0 and 24");
		}
		
		if (hour24 == 0 || hour24 == 24)
			return "twelve";
		if (hour24 <= 12)
			return CommonUtils.minConvert(hour24);
		return CommonUtils.minConvert(hour24 - 12);
	}
	
	public static String minConvert(int number) {
		if (number < 0 || number > 59) {
			throw new IllegalArgumentException("Minute Number must be between 1 and 59");
		}
		if (number == 0)
			return "";
		if (number < 20)
			return TimeConstants.BELOW_20[number];
		if (number % 10 == 0)
			return TimeConstants.TENS[number / 10];
		return TimeConstants.TENS[number / 10] + "-" + TimeConstants.BELOW_20[number % 10];
	}
    
	
	public static Time parse(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("Input cannot be null or empty");
		}

		String trimmed = input.trim();
		java.util.regex.Matcher matcher = TIME_PATTERN.matcher(trimmed);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Must be in HH:mm format (e.g., 14:30)");
		}

		int hour = Integer.parseInt(matcher.group(1));
		int minute = Integer.parseInt(matcher.group(2));

		if (hour > 23) {
			throw new IllegalArgumentException("Hour must be 00-23");
		}

		return new Time(hour, minute);
	}

	

}
