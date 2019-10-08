package com.ariclee.cache.xml;

import com.ariclee.cache.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

@Controller
public class XmlController {

    @Autowired
    XmlBookService service;

    // http://127.0.0.1:8087/cache/10
    @RequestMapping("/cache/{id}")
    @ResponseBody
    public String find(@PathVariable String id) {
        Book book = service.findBook(id);
        if (book == null) {
            return "no exists";
        }
        return book.toString();
    }

    // http://127.0.0.1:8087/cache/find/EfficetiveJava
    @RequestMapping("/cache/find/{name}")
    @ResponseBody
    public String findByName(@PathVariable String name) {
        return service.findBookByName(name).toString();
    }

    // http://127.0.0.1:8087/cache/save1/10
    @RequestMapping("/cache/save1/{id}")
    @ResponseBody
    public String save1(@PathVariable String id) {
        Book book = new Book();
        book.setId(id);
        book.setName("aaa");
        service.saveAndAddAllCacheMapping(book);
        return "success";
    }

    // http://127.0.0.1:8087/cache/keyGeneratorTest/10
    @RequestMapping("/cache/keyGeneratorTest/{id}")
    @ResponseBody
    public String keyGeneratorTest(@PathVariable String id) {
        Book book = new Book();
        book.setId(id);
        book.setName("test");
        service.keyGeneratorTest(book);
        return "success";
    }
}
