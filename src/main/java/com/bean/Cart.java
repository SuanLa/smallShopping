package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/10/31 16:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
    private int id;
    private int user;
    private int item;
    private List<Item> items;
}
