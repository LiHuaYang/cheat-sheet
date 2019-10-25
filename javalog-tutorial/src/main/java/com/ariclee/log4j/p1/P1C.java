package com.ariclee.log4j.p1;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lihy
 * @version 1.0  2019/10/10
 */
public class P1C {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(P1C.class);
//        Logger logger = Logger.getLogger("p1a");
        logger.debug("log4j debug");
        logger.info("log4j info");
        logger.error("log4j error");
    }
}

