package com.controller;

import com.bean.Other;
import com.bean.User;
import com.service.OtherService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @author Tomcat
 * @Date 2022/10/28 22:52
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private OtherService otherService;

    /**
     * Login string.
     *
     * @param username the username
     * @param password the password
     * @param hsr      the hsr
     * @return the string
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse hsr) throws UnsupportedEncodingException {
        /*通过service拿到user对象*/
        User login = userService.login(password, username);

        /*拿到用户的其余信息*/
        Other other = otherService.queryByUserId(login.getId());

        /*创建次数的Cookie*/
        Cookie times = new Cookie("times", URLEncoder.encode(String.valueOf(other.getTimes()),StandardCharsets.UTF_8));
        times.setPath("/");
        times.setMaxAge(-1);

        /*获取用户唯一标识符*/
        String s = String.valueOf(login.getId());

        /*创建Cookie对象并将userId放入*/
        Cookie userId = new Cookie("userId", URLEncoder.encode(s, StandardCharsets.UTF_8));
        userId.setPath("/");
        userId.setMaxAge(-1);
        /*输出到客户端*/
        hsr.addCookie(userId);

        /*配置Cookie*/
        Cookie un = new Cookie("username", URLEncoder.encode(login.getUsername(), StandardCharsets.UTF_8));
        Cookie pw = new Cookie("password", URLEncoder.encode(login.getPassword(), StandardCharsets.UTF_8));
        un.setPath("/");
        pw.setPath("/");
        un.setMaxAge(60*60*24);
        pw.setMaxAge(60*60*24);

        /*判断密码是否正确，正确重定向到welcome页面，失败重定向到登陆页面*/
        if (login.getPassword().equals(password)){
            /*添加进response*/
            hsr.addCookie(un);
            hsr.addCookie(pw);
            hsr.addCookie(times);

            /*更新登录次数*/
            otherService.increaseTimesById(other.getId(),other.getTimes()+1);
            return "redirect:/welcome.html";
        }else {
            return "redirect:/index.html";
        }
    }

    /**
     * Register string.
     *
     * @param username the username
     * @param password the password
     * @return the string
     */
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password) throws UnsupportedEncodingException {
        boolean register = userService.register(password, username);

        if (register){
            User login = userService.login(password, username);
            boolean b = otherService.creatCount(login.getId());
            if (b){
                return "redirect:/index.html";
            }else {
                return "redirect:/register.html";
            }
        }else {
            return "redirect:/register.html";
        }
    }

    /**
     * Auto login string.
     *
     * @param username the username
     * @param password the password
     * @param hsr      the hsr
     * @return the string
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @RequestMapping("/auto")
    public String autoLogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletResponse hsr) throws UnsupportedEncodingException {
        User autoLogin = userService.autoLogin(username, password);

        /*拿到用户的其余信息*/
        Other other = otherService.queryByUserId(autoLogin.getId());

        /*创建次数的Cookie*/
        Cookie times = new Cookie("times", URLEncoder.encode(String.valueOf(other.getTimes()),StandardCharsets.UTF_8));
        times.setPath("/");
        times.setMaxAge(-1);

        String s = String.valueOf(autoLogin.getId());

        /*创建Cookie对象并将userId放入*/
        Cookie userId = new Cookie("userId", URLEncoder.encode(s, StandardCharsets.UTF_8));
        userId.setPath("/");
        userId.setMaxAge(-1);
        /*输出到客户端*/
        hsr.addCookie(userId);

        if (autoLogin.getPassword().equals(password)){
            hsr.addCookie(times);
            /*更新登录次数*/
            otherService.increaseTimesById(other.getId(),other.getTimes()+1);
            return "redirect:/welcome.html";
        }else {
            return "redirect:/index.html";
        }
    }
}
