package com.ariclee.cache.xml;

import com.ariclee.cache.Book;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * 自定义缓存键生成器
 * @author lihy
 * @version 1.0  2019/10/8
 */
public class CustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        String key = this.generateKey(params);
        System.out.println("生成缓存键：" + key);
        return key;
    }

    private String generateKey(Object[] params) {
        if (params == null || params.length < 1) {
            return "";
        }
        StringJoiner stringJoiner = new StringJoiner(":");
        for (Object obj : params) {
            if (obj instanceof Book) {
                Book temp = (Book) obj;
                stringJoiner.add(temp.getId() + ":" + temp.getName());
            }
            else {
                stringJoiner.add(obj.toString());
            }
        }
        return stringJoiner.toString();
    }
}
