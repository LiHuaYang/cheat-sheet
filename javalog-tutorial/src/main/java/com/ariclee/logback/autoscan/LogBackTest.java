package com.ariclee.logback.autoscan;

import ch.qos.logback.classic.util.ContextInitializer;
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

    private static String log_path = "D:\\workspace\\git\\cheat-sheet\\javalog-tutorial\\src\\main\\resources\\logback-autoscan.xml";

    public static void main(String[] args) {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, log_path);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new LoggerThread(), 0, 2, TimeUnit.SECONDS);
    }

    static class LoggerThread implements Runnable {
        Logger logger = LoggerFactory.getLogger(LogBackTest.class);
        @Override
        public void run() {
            logger.info("logged by timing thread");
        }
    }
}
