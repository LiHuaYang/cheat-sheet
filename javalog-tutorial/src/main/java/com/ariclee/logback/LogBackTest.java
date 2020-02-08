package com.ariclee.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
