package com.ariclee.test;


import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现 HttpRequestHandler 接口没有返回值
 * @author lihy
 * @version 1.0  2019/2/27
 */
public class TestController implements HttpRequestHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    private org.slf4j.Logger logger1 = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("##### log4j info test #####");
        logger1.info("##### slf4j info test #####");
        response.getWriter().println("TestController2 implements HttpRequestHandler");
    }
}
