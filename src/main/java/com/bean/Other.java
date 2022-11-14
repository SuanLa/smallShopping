package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tomcat
 * @Date 2022/11/14 19:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Other {
    private int id;
    private int userId;
    private int times;
    private String message;
}
