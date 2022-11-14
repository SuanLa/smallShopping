package com.dao;

import com.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Tomcat
 * @Date 2022/10/28 22:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ioc.xml", "classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserDAOTest {
    @Resource
    private UserDAO userDAO;
    @Test
    public void queryByName() {
        User user = userDAO.queryByName("张三");
        System.out.println(user);
    }

    /**
     * Creat user.
     */
    @Test
    public void creatUser() {
        User user = new User(0, "赵六", "123123",null);
        int i = userDAO.creatUser(user);
        System.out.println(i);
    }
}