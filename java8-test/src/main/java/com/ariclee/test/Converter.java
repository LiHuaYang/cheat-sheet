package com.ariclee.test;

/**
 * @author lihy
 * @version 1.0  2019/5/22
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
