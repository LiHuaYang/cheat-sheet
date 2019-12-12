package com.ariclee.springboot.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    TestService service;

    public TestController(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("interface1");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20); // Set limit QPS to 20.
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

//    @SentinelResource(blockHandler = "blockHandler1")
//    @SentinelResource(fallback = "fallBack1") // 也能进入
//    @SentinelResource // 配置为空，抛出 com.alibaba.csp.sentinel.slots.block.flow.FlowException
    @SentinelResource(blockHandler = "blockHandler1", fallback = "fallBack1")
    @RequestMapping("/interface1")
    @ResponseBody
    public String interface1(String id) {
        service.aaa(id);
        return "interface1";
    }
    // http://127.0.0.1:8087/interface1

    // http://127.0.0.1:8087/interface2
    @SentinelResource("/interface2")
    @RequestMapping("/interface2")
    @ResponseBody
    public String interface2(String id) {
        System.out.println("interface2");
        return "interface2";
    }

    // 生效
    public String fallBack1(String id, Throwable ex) {
        System.out.println("interface1 block use fallBack1 method");
        return "interface1 block";
    }

    // 生效
    public String fallBack2(String id) {
        System.out.println("interface1 block use fallBack2 method");
        return "interface1 block";
    }

    // 生效
    public String blockHandler1(String id, BlockException ex) {
        System.out.println("interface1 block use blockHandler1 method");
        return "interface1 block";
    }

    // 不生效
    public String blockHandler2(String id) {
        System.out.println("interface1 block use blockHandler1 method");
        return "interface1 block";
    }

    // 不生效
    public String blockHandler3(String id, Throwable e) {
        System.out.println("interface1 block use blockHandler3 method");
        return "interface1 block";
    }
}
