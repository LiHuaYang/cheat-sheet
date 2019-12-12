package com.ariclee.springboot.sentinel;

import org.springframework.stereotype.Component;

/**
 * @author lihy
 * @version 1.0  2019/12/6
 */
@Component
public class TestService {

    // blockHandler、fallback 都配置走 fallbackFor1
//    @SentinelResource(blockHandler = "blockFor1", fallback = "fallbackFor1")

    // 配置为空，抛出 com.alibaba.csp.sentinel.slots.block.degrade.DegradeException
//    @SentinelResource

    public void aaa(String id){
        System.out.println("enter TestService#aaa method");
        try {
//            Thread.sleep(2000);
        }
        catch (Exception e) {

        }
    }

    public void blockFor1(String id, Throwable ex) {
        System.out.println("TestService#aaa block");
    }

    // blockHandler 函数，原方法调用被限流/降级/系统保护的时候调用
    public void fallbackFor1(String id, Throwable ex) {
        System.out.println("TestService#aaa fallback");
    }
}
