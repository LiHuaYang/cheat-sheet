package com.ariclee.springboot.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    @Cacheable(value = "books", key = "#id", unless = "#result == null")
    public Book findBook(String id) {
        return respository.get(id);
    }

    // 只缓存参数名中包含 Java 的（使用 condition 实现）
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

    @Caching(
            cacheable = {
                    @Cacheable(value = "books", key = "#name")
            },
            put = {
                    @CachePut(value = "books", key = "#result.id", condition = "#result != null"),
                    @CachePut(value = "books", key = "#result.name", condition = "#result != null")
            }
    )
    public Book findBookByName1(String name) {
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

    @CachePut(value = "books", key = "#book.id")
    public Book saveBook(Book book) {
        respository.put(book.getId(), book);
        return book;
    }

    // 当参数值为 10 时，才写入缓存
    @CachePut(value = "books", key = "#book.id", condition = "#book.id == 10")
    public Book saveBook1(Book book) {
        respository.put(book.getId(), book);
        return book;
    }

    // 当参数值为 10 时，才不写入缓存
    @CachePut(value = "books", key = "#book.id", unless = "#book.id == 10")
    public Book saveBook2(Book book) {
        respository.put(book.getId(), book);
        return book;
    }

    @Caching(
            put = {
                    @CachePut(value = "books", key = "#book.id"),
                    @CachePut(value = "books", key = "#book.name"),
            }
    )
    public Book saveBook3(Book book) {
        respository.put(book.getId(), book);
        return book;
    }

    @CacheEvict(value = "books", key = "id", allEntries = false)
    public void delete(String id) {
        respository.remove(id);
    }

    @CacheEvict(value = "books", allEntries = true)
    public void deleteAll() {
        respository.clear();
    }
}
