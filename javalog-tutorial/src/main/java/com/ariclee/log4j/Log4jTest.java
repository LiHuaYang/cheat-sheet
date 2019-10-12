package com.ariclee.log4j;

import org.apache.log4j.Logger;

/**
 * @author lihy
 * @version 1.0  2019/10/12
 */
public class Log4jTest {

    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(Log4jTest.class);
//        logger.debug("log4j debug");
//        logger.info("log4j info");
//        logger.error("log4j error");

        Logger logger = Logger.getLogger("TEST");
        logger.debug("log4j debug");
        logger.info("log4j info");
        logger.error("log4j error");
    }
}
