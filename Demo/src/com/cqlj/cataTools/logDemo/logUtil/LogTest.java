package com.cqlj.cataTools.logDemo.logUtil;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	static Logger logger = LoggerFactory.getLogger(LogTest.class);
	public static void main(String[] args) {
		logger.error("hello {}", new Date());
	}
}
