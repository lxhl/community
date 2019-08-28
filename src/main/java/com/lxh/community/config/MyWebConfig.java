package com.lxh.community.config;

import com.lxh.community.interceptor.LoginInterceptor;
import com.lxh.community.interceptor.PublishInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LXH
 * @date 2019/8/28 -11:35
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/");
        registry.addInterceptor(new PublishInterceptor()).addPathPatterns("/publish");
    }
}
