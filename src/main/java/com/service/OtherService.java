package com.service;

import com.bean.Other;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

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
     * @param userId  the user id
     * @param message the message
     * @return the boolean
     */
    public boolean updateMessageByUserId(int userId,String message);

    /**
     * Update times by id boolean.
     *
     * @param id    the id
     * @param times the times
     */
    public void increaseTimesById(int id, int times);

    /**
     * Query by user id other.
     *
     * @param userId the user id
     * @return the other
     */
    public Other queryByUserId(int userId);
}
