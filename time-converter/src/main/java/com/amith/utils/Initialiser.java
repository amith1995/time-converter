package com.amith.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amith.constants.TimeConstants;

public class Initialiser {

	private static final Logger LOG = LogManager.getLogger(Initialiser.class);
	
	
	public static final Map<String, String> CONFIG_MAP = new HashMap<String, String>();
	private String configPath;

	public Initialiser(String configPath) {
		this.configPath = configPath;
	}

	public void readProperties() {
		LOG.info("Reading configurations.....");
		Properties properties = new Properties();
		File file = new File(configPath);
		try {
			properties.load(new FileInputStream(file));
			initializeConfigMap(properties);

		} catch (IOException e) {
			LOG.error("ERORR : ", e);
		} catch (Exception e) {
			LOG.error("ERORR : ", e);
		}
	}
	

	private void initializeConfigMap(Properties properties) {
		
		CONFIG_MAP.put(TimeConstants.COUNTRY_MODE, properties.getProperty(TimeConstants.COUNTRY_MODE).trim());

		CONFIG_MAP.put(TimeConstants.INPUT_VALUE, properties.getProperty(TimeConstants.INPUT_VALUE).trim());

	}
	
}
