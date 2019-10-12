package com.ariclee.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lihy
 * @version 1.0  2019/7/8
 */
public class LogBackTest {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogBackTest.class);
        logger.debug("logback debug");
        logger.info("logback info");
        logger.error("logback error");
    }
}
