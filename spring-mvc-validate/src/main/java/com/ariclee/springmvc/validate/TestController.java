package com.ariclee.springmvc.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @version 1.0  2019/10/31
 */

@RestController("/")
public class TestController {


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String test(@Validated Param param, BindingResult bindingResult) {
        System.out.println(bindingResult.getAllErrors());
        return "success";
    }
}
