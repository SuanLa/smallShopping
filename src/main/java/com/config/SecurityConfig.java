package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Tomcat
 * @Date 2022/12/9 16:53
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/welcome.html")
                .failureUrl("/error.html").permitAll()
                .and().cors()
                .and().authorizeRequests()
                .antMatchers("/static/**","/user/login","/index.html","/register.html","/user/register","/user/auto","/jquery-3.6.0.js").permitAll()
                .antMatchers("/welcome.html","/other.html","/cart.html","/item.html","/other/**","/item/**","/cart/**").authenticated()
                .anyRequest().authenticated()
                .and().rememberMe()
                .key("welcome")
                .and().csrf().disable();
    }
}
