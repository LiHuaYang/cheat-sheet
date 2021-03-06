package com.ariclee.cache.xml;

import com.ariclee.cache.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XmlBookService {

    private static Map<String, Book> respository = new HashMap<>();

    static {
        respository.put("1", new Book("Thinking In Java"));
        respository.put("2", new Book("EfficetiveJava"));
    }

    public Book findBook(String id) {
        return respository.get(id);
    }

    public Book findBookByName(String name) {
        Set<Map.Entry<String, Book>> entries = respository.entrySet();
        for (Map.Entry<String, Book> entry : entries) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return new Book();
    }

    public void saveBook(Book book) {
        respository.put(book.getId(), book);
    }

    public Book saveAndAddAllCacheMapping(Book book) {
        respository.put(book.getId(), book);
        return book;
    }

    public void delete(String id) {
        respository.remove(id);
    }

    public void deleteAll() {
        respository.clear();
    }

    public String keyGeneratorTest(Book book) {
        return "success";
    }
}
