package com.amith.processor.british;

import com.amith.constants.TimeConstants;
import com.amith.processor.TimeProcessor;
import com.amith.utils.CommonUtils;
import com.amith.utils.Time;

public class BritishTimeProcessor extends TimeProcessor {

	@Override
	public String convert(Time time) {
		int hour24 = time.getHour();
		int minute = time.getMinute();

		if (hour24 == 0 && minute == 0)
			return TimeConstants.MIDNIGHT;
		if (hour24 == 12 && minute == 0)
			return TimeConstants.NOON;

		String hourWord = CommonUtils.to12HourWord(hour24);
		String nextHourWord = CommonUtils.to12HourWord((hour24 + 1) % 24);

		if (minute == 0) {
			return hourWord + " " + TimeConstants.OCLOCK;
		}

		if (minute % 5 == 0) {
			if (minute == 15) {
				return TimeConstants.QUARTER + " " + TimeConstants.PAST + " " + hourWord;
			} else if (minute == 30) {
				return TimeConstants.HALF + " " + TimeConstants.PAST + " " + hourWord;
			} else if (minute == 45) {
				return TimeConstants.QUARTER + " " + TimeConstants.TO + " " + nextHourWord;
			} else if (minute <= 30) {
				String minWord = CommonUtils.minConvert(minute);
				return minWord + " " + TimeConstants.PAST + " " + hourWord;
			} else {
				String minWord = CommonUtils.minConvert(60 - minute);
				return minWord + " " + TimeConstants.TO + " " + nextHourWord;
			}
		}

		// Non-multiples of 5: e.g., "six thirty-two"
		String minWord = CommonUtils.minConvert(minute);
		return hourWord + " " + minWord;
	}
}
