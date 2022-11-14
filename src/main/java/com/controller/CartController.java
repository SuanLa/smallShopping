package com.controller;

import com.bean.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author Tomcat
 * @Date 2022/11/8 17:36
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;

    /**
     * Query all list.
     *
     * @param userId the user id
     * @return the list
     */
    @RequestMapping(value = "/paging")
    @ResponseBody
    public JsonNode queryAll(int userId) throws JsonProcessingException {
        return cartService.queryAll(userId);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public boolean deleteItem(int itemId,int userId){
        return cartService.deleteItem(itemId,userId);
    }
}
