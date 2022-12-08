package com.service.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;

/**
 * @author Tomcat
 * @Date 2022/12/8 21:44
 */
@Configuration
@Enable
public class WebSecurityConfig extends WebSessionServerSecurityContextRepository {
}
