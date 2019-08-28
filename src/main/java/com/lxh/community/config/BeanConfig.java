package com.lxh.community.config;

import com.lxh.community.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LXH
 * @date 2019/8/28 -14:34
 */
@Configuration
public class BeanConfig {
    @Bean
    public LoginInterceptor loginInterceptor(){
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        return loginInterceptor;
    }
}
