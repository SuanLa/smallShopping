package com.dao;

import com.bean.Other;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/11/14 19:04
 */
public interface OtherDAO {
    /**
     * Creat by user int.
     *
     * @param other the other
     * @return the int
     */
    public int creat(Other other);

    /**
     * Retrieve by user other.
     *
     * @param userId the user id
     * @return the other
     */
    public Other retrieveByUser(int userId);

    /**
     * Retrieve by id other.
     *
     * @param id the id
     * @return the other
     */
    public Other retrieveById(int id);

    /**
     * Retrieve all message list.
     *
     * @return the list
     */
    public List<Other> retrieveAllMessage();

    /**
     * Update times by id int.
     *
     * @param id    the id
     * @param times the times
     * @return the int
     */
    public int updateTimesById(@Param("id") int id,@Param("times") int times);

    /**
     * Update message by id int.
     *
     * @param userId  the user id
     * @param message the message
     * @return the int
     */
    public int updateMessageByUserId(@Param("userId") int userId,@Param("message") String message);
}
