package com.dao;

import com.bean.Other;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Tomcat
 * @Date 2022/11/14 20:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ioc.xml", "classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class OtherDAOTest {
    @Resource
    private OtherDAO otherDAO;

    /**
     * Creat.
     */
    @Test
    public void creat() {
        Other other = new Other(0,10002,1,"布响丸辣");
        int creat = otherDAO.creat(other);
        System.out.println(creat);
    }

    @Test
    public void retrieveByUser() {
        Other other = otherDAO.retrieveByUser(10001);
        System.out.println(other);
    }

    @Test
    public void retrieveById() {
        Other other = otherDAO.retrieveById(1);
        System.out.println(other);
    }

    @Test
    public void retrieveAllMessage() {
        List<Other> others = otherDAO.retrieveAllMessage();
        others.forEach(System.out::println);
    }

    @Test
    public void updateTimesById() {
        int i = otherDAO.updateTimesById(1, 2);
        System.out.println(i);
    }
}