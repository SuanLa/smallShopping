package com.dao;

import com.bean.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Cart dao test.
 *
 * @author Tomcat
 * @Date 2022 /11/6 21:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ioc.xml", "classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class CartDAOTest {
    @Resource
    private CartDAO cartDAO;

    @Test
    public void queryByUserId() {
        List<Cart> carts = cartDAO.queryByUserId(10001);
        carts.forEach(System.out::println );
    }

    @Test
    public void queryItem() {
        Cart cart = cartDAO.queryItem(1);
        System.out.println(cart);
    }

    @Test
    public void addItemById() {
        Cart cart = new Cart(0, 10001, 10006,null);
        int i = cartDAO.addItemById(cart);
        System.out.println(i);
    }

    @Test
    public void deleteItemById() {
        boolean b = cartDAO.deleteItemById(10001, 10005);
        System.out.println(b);
    }
}