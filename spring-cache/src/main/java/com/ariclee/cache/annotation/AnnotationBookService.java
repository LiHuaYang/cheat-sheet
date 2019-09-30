package com.ariclee.cache.annotation;

import com.ariclee.cache.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class AnnotationBookService {

    private static Map<String, Book> respository = new HashMap<>();

    static {
        respository.put("1", new Book("Thinking In Java"));
        respository.put("2", new Book("EfficetiveJava"));
    }

    @Cacheable(value = "books")
    public Book findBook(String id) {
        return respository.get(id);
    }

    // 不缓存返回实体中包含 default 字样的（使用 condition 实现）
    @Cacheable(value = "books", condition = "#name.contains('Java')")
    public Book findBookByName(String name) {
        Set<Map.Entry<String, Book>> entries = respository.entrySet();
        for (Map.Entry<String, Book> entry : entries) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return new Book();
    }

    // 不缓存返回实体中包含 default 字样的（使用 unless 实现）
//    @Cacheable(value = "books", unless = "#result.name.contains('default')")
//    public Book findBookByName(String name) {
//        Set<Map.Entry<String, Book>> entries = respository.entrySet();
//        for (Map.Entry<String, Book> entry : entries) {
//            if (entry.getValue().getName().equals(name)) {
//                return entry.getValue();
//            }
//        }
//        return new Book();
//    }

    public String saveBook(String id) {
        return "default annotation book name";
    }
}
