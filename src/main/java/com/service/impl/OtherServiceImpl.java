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
        Other other = new Other(0, userId, 1, null);
        int creat = otherDAO.creat(other);
        if (creat==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean updateMessageByUserId(int userId, String message) {
        int i = otherDAO.updateMessageByUserId(userId, message);
        if (i==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void increaseTimesById(int id, int times) {
        int i = otherDAO.updateTimesById(id, times);
        if (i==0){
        }else {
        }
    }

    @Override
    public Other queryByUserId(int userId) {
        return otherDAO.retrieveByUser(userId);
    }
}
