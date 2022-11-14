package com.service;

import com.bean.User;

import java.io.UnsupportedEncodingException;

/**
 * @author Tomcat
 * @Date 2022/10/28 22:45
 */
public interface UserService {
    /**
     * Login user.
     *
     * @param password the password
     * @param username the username
     * @return the user
     */
    public User login(String password,String username) throws UnsupportedEncodingException;

    /**
     * Register boolean.
     *
     * @param password the password
     * @param username the username
     * @return the boolean
     */
    public boolean register(String password,String username);

    /**
     * Auto login boolean.
     *
     * @param password the password
     * @param username the username
     * @return the boolean
     */
    public User autoLogin(String password,String username);
}
