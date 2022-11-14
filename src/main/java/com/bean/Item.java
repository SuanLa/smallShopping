package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tomcat
 * @Date 2022/10/28 17:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    private int id;
    private String name;
    private int price;
    private int number;
}
