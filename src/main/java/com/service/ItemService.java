package com.service;

import com.bean.Item;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/6 22:23
 */
public interface ItemService {
    /**
     * Query all list.
     *
     * @param id the id
     * @return the list
     */
    public Item queryById(int id);

    /**
     * Query page list.
     *
     * @param page the page
     * @param size the size
     * @return the list
     */
    public JsonNode queryPage(int page,int size);
}
