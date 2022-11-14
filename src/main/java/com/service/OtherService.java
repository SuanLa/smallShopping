package com.service;

import com.bean.Other;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/14 20:36
 */
@Service
public interface OtherService {
    /**
     * Query all message list.
     *
     * @return the list
     */
    public JsonNode queryAllMessage();

    /**
     * Creat count boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    public boolean creatCount(int userId);

    /**
     * Update message by id boolean.
     *
     * @param id      the id
     * @param message the message
     * @return the boolean
     */
    public boolean updateMessageById(int id,String message);

    /**
     * Update times by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean increaseTimesById(int id);
}
