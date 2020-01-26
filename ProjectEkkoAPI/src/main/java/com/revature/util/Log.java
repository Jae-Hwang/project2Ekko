package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Log {
	private static final Logger log = LogManager.getRootLogger();
	
	public void info(String msg) {
		log.info(msg);
	}
	
	public void debug(String msg) {
		log.debug(msg);
	}
	
	public void trace(String msg) {
		log.trace(msg);
	}
	
	public void warn(String msg) {
		log.warn(msg);
	}
}
