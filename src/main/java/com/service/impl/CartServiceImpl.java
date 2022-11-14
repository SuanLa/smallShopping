package com.service.impl;

import com.bean.Cart;
import com.bean.Item;
import com.dao.CartDAO;
import com.dao.ItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/8 17:44
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartDAO cartDAO;

    @Resource
    private ItemDAO itemDAO;

    @Override
    public JsonNode queryAll(int userId) {
        List<Cart> carts = cartDAO.queryByUserId(userId);
        List<Item> items = new ArrayList<>();
        for (Cart c :
                carts) {
            items.addAll(c.getItems());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String s = objectMapper.writeValueAsString(items);
            JsonNode jsonNode = objectMapper.readTree(s);
            return jsonNode;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addItemToCart(String itemId,String userId) {
        Item item = itemDAO.queryById(Integer.parseInt(itemId));
        int i1 = Integer.parseInt(userId);
        Cart cart = new Cart(0, i1,item.getId() , null);
        int i = cartDAO.addItemById(cart);
        if (i==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteItem(int id, int userId) {
        return cartDAO.deleteItemById(id,userId);
    }
}
