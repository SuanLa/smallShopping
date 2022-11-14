package com.service;

import com.bean.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * The interface Cart service.
 *
 * @author Tomcat
 * @Date 2022 /11/6 22:13
 */
public interface CartService {
    /**
     * Query all list.
     *
     * @param userId the user id
     * @return the list
     */
    public JsonNode queryAll(int userId) throws JsonProcessingException;

    /**
     * Add item to cart boolean.
     *
     * @param itemId the item id
     * @param userId the user id
     * @return the boolean
     */
    public boolean addItemToCart(String itemId,String userId);

    /**
     * Delete item boolean.
     *
     * @param id     the id
     * @param userId the user id
     * @return the boolean
     */
    public boolean deleteItem(int id,int userId);
}
