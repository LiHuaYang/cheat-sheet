package com.ariclee.logback.p1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lihy
 * @version 1.0  2019/10/10
 */
public class P1C {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(P1C.class);
        logger.debug("debug,debug");
        logger.info("info,info");
    }
}
