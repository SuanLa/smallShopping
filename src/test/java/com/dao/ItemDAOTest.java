package com.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bean.Item;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/10/28 22:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ioc.xml", "classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class ItemDAOTest {
    @Resource
    private ItemDAO itemDAO;
    @Test
    public void queryById() {
        Item item = itemDAO.queryById(10001);
        System.out.println(item);
    }

    /**
     * Query by page.
     */
    @Test
    public void queryByPage(){
        List<Item> items = itemDAO.queryByPage(0, 6);
        System.out.println(items);
    }
}