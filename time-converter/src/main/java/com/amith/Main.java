package com.amith;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amith.processor.TimeProcessor;
import com.amith.utils.Initialiser;

public class Main {
	
	private static final Logger LOG = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		if (args.length != 1) {

			LOG.error("Usage <Jar> <Config.properties>");
		} else {
			Initialiser init = new Initialiser(args[0]);
			init.readProperties();

			TimeProcessor.start();
			LOG.info("Process Completed!!! Please refer the log file for more informaton");
		}
		
	}

}
