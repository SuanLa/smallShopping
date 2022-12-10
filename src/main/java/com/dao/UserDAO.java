package com.dao;

import com.bean.User;

/**
 * The interface User dao.
 *
 * @author Tomcat
 * @Date 2022 /10/28 17:45
 */

public interface UserDAO {
    /**
     * Query by id user.
     *
     * @param name the name
     * @return the user
     */
    public User queryByName(String name);

    /**
     * Creat user int.
     *
     * @param user the user
     * @return the int
     */
    public int creatUser(User user);

    /**
     * Query cart user.
     *
     * @param id the id
     * @return the user
     */
    public User queryCartId(int id);
}
