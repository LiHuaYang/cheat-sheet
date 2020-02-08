package com.ariclee.mybatis.controller;

import com.ariclee.mybatis.QueryOrgInfoReq;
import com.ariclee.mybatis.mapper.OrgInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
@RestController("/")
public class TestController {

    @Autowired
    OrgInfoMapper mapper;

    @RequestMapping("test")
    public String test1() {
        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(1).build();
        System.out.println(mapper.getBy(orgInfoReq));
        return "success";
    }
}
