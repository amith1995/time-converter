package com.amith.processor;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amith.constants.TimeConstants;
import com.amith.processor.british.BritishTimeProcessor;
import com.amith.utils.CommonUtils;
import com.amith.utils.Initialiser;
import com.amith.utils.Time;

public abstract class TimeProcessor {

	private static final Logger LOG = LogManager.getLogger(TimeProcessor.class);

	protected static Map<String, String> configMap = Initialiser.CONFIG_MAP;

	public static void start() {

		Time time = null;

		try {
			time = CommonUtils.parse(configMap.get(TimeConstants.INPUT_VALUE));
		} catch (IllegalArgumentException e) {
			LOG.error("Error: " + e.getMessage());
			System.exit(1);
		}

		if (null != time) {
			if (configMap.get(TimeConstants.COUNTRY_MODE).equals(TimeConstants.TIME_FORMAT_BRITISH)) {
				BritishTimeProcessor britishProcessor = new BritishTimeProcessor();
				String outputValue = britishProcessor.convert(time);
				LOG.info("Here is the output - " + outputValue);
			} else if (configMap.get(TimeConstants.COUNTRY_MODE).equals(TimeConstants.TIME_FORMAT_GERMAN)) {
				LOG.info("Hire me to complete this project :p !!!");
			}
		} else {
			LOG.error("An Unforseen Error Occurred. Please check the logs !!");
		}
	}

	public abstract String convert(Time time);

}
