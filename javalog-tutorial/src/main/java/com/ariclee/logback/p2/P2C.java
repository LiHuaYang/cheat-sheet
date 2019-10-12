package com.ariclee.logback.p2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lihy
 * @version 1.0  2019/10/10
 */
public class P2C {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(P2C.class);
        logger.debug("debug,debug");
        logger.info("info,info");
    }
}
