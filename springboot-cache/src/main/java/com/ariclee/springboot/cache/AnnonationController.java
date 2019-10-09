package com.ariclee.springboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnonationController {

    @Autowired
    AnnotationBookService service;

    // http://127.0.0.1:8087/cache
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
        book.setName("测试");
//        service.saveBook1(book);
        service.saveBook(book);
        return "success";
    }
}
