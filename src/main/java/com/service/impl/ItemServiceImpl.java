package com.service.impl;

import com.bean.Item;
import com.dao.ItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/8 18:01
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDAO itemDAO;

    @Override
    public Item queryById(int id) {
        return itemDAO.queryById(id);
    }

    @Override
    public JsonNode queryPage(int num,int size) {
        /*分页查询*/
        List<Item> items = itemDAO.queryByPage(num, size);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String s = objectMapper.writeValueAsString(items);

            return objectMapper.readTree(s);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
