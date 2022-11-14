package com.controller;

import com.dao.ItemDAO;
import com.fasterxml.jackson.databind.JsonNode;
import com.service.CartService;
import com.service.ItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Tomcat
 * @Date 2022/11/9 22:00
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemService;

    @Resource
    private CartService cartService;

    @RequestMapping("/paging")
    @ResponseBody
    public JsonNode queryItemByPage(int page,int size){
        return itemService.queryPage(page, size);
    }

    /**
     * Add item to cart boolean.
     *
     * @param itemId the item id
     * @param userId the user id
     * @return the boolean
     */
    @RequestMapping("/add")
    @ResponseBody
    public boolean addItemToCart(@RequestParam("itemId") String itemId,@RequestParam("userId") String userId){
        return cartService.addItemToCart(itemId,userId);
    }
}
