package com.ariclee.java8.tutorial;

import java.util.Optional;

/**
 * @author lihy
 * @version 1.0  2019/11/12
 */
public class OptionalDemo {


    public static void main(String[] args) {
        // 给与一个非空值
        Optional<String> username = Optional.of("kobe");
        // 传入参数为null，抛出NullPointerException.
        Optional<String> nullValue = Optional.of(null);
    }
}
