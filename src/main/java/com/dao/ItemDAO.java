package com.dao;

import com.bean.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/10/28 17:46
 */

public interface ItemDAO {
    /**
     * Query by id item.
     *
     * @param id the id
     * @return the item
     */
    public Item queryById(int id);

    /**
     * Query all list.
     *
     * @return the list
     */
    public List<Item> queryAll();

    /**
     * Query by page list.
     *
     * @param start    the start
     * @param pageSize the page size
     * @return the list
     */
    public List<Item> queryByPage(@Param("start") int start,@Param("pageSize") int pageSize);

    /**
     * Query by name item.
     *
     * @param name the name
     * @return the item
     */
    public Item queryByName(String name);
}
