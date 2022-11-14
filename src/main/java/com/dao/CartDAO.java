package com.dao;

import com.bean.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Cart dao.
 *
 * @author Tomcat
 * @Date 2022 /10/31 16:16
 */
public interface CartDAO {

    /**
     * Query by user cart.
     *
     * @param userId the user id
     * @return the cart
     */
    public List<Cart> queryByUserId(int userId);

    /**
     * Query item cart.
     *
     * @param id the id
     * @return the cart
     */
    public Cart queryItem(int id);

    /**
     * Add item by name int.
     *
     * @param cart the cart
     * @return the int
     */
    public int addItemById(Cart cart);

    /**
     * Delete item by id int.
     *
     * @param id     the id
     * @param userId the user id
     * @return the int
     */
    public boolean deleteItemById(@Param("id") int id,@Param("userId") int userId);
}
