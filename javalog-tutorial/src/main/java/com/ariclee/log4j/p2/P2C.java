package com.ariclee.log4j.p2;

import com.ariclee.log4j.p1.P1C;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lihy
 * @version 1.0  2019/10/10
 */
public class P2C {

    public static void main(String[] args) {
        org.apache.log4j.Logger logger = Logger.getLogger(P2C.class);
        logger.debug("debug,debug");
        logger.info("info,info");
    }
}
