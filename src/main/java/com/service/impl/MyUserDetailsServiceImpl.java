package com.service.impl;

import com.bean.User;
import com.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/12/9 18:28
 */
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.queryByName(username);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<GrantedAuthority> role = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),role);
    }
}
