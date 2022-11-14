package com.service.impl;

import com.bean.Other;
import com.dao.OtherDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.OtherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/14 20:45
 */
@Service
public class OtherServiceImpl implements OtherService {
    @Resource
    private OtherDAO otherDAO;

    @Override
    public JsonNode queryAllMessage() {
        List<Other> others = otherDAO.retrieveAllMessage();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String s = objectMapper.writeValueAsString(others);
            JsonNode jsonNode = objectMapper.readTree(s);
            return jsonNode;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean creatCount(int userId) {
        return false;
    }

    @Override
    public boolean updateMessageById(int id, String message) {
        return false;
    }

    @Override
    public boolean increaseTimesById(int id) {
        return false;
    }
}
