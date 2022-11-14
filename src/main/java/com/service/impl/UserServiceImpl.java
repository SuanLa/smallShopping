package com.service.impl;

import com.bean.User;
import com.dao.UserDAO;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tomcat
 * @Date 2022/10/28 22:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    public User login(String password,String username){

        User user = userDAO.queryByName(username);
        if (password.equals(user.getPassword())){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public boolean register(String password, String username) {
        User user = new User(0, username, password,null);
        int i = userDAO.creatUser(user);
        if (i==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User autoLogin( String username,String password) {
        User user = userDAO.queryByName(username);
        if (password.equals(user.getPassword())){
            return user;
        }else {
            return null;
        }
    }

}
