package com.ariclee.cache.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlController {

    @Autowired
    XmlBookService service;

    // http://127.0.0.1:8087/cache
    @RequestMapping("/cache")
    @ResponseBody
    public String find() {
        return service.findBook("1").toString();
    }

    // http://127.0.0.1:8087/cache/find/EfficetiveJava
    @RequestMapping("/cache/find/{name}")
    @ResponseBody
    public String findByName(@PathVariable String name) {
        return service.findBookByName(name).toString();
    }

    // http://127.0.0.1:8087/cache/load
    @RequestMapping("/cache/load")
    @ResponseBody
    public String load() {
        return service.loadBooks();
    }
}
