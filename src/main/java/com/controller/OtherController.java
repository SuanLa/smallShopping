package com.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.service.OtherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Tomcat
 * @Date 2022/11/14 20:47
 */
@Controller
@RequestMapping("/other")
public class OtherController {
    @Resource
    private OtherService otherService;

    @RequestMapping("/messages")
    @ResponseBody
    public JsonNode getMessage(){
        return otherService.queryAllMessage();
    }
}
