package com.psj.fmmall.config;

import com.psj.fmmall.interceptor.CheckTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author psj
 * @date 2022/7/21 23:59
 * @File: InterceptorConfig.java
 * @Software: IntelliJ IDEA
 */

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private CheckTokenInterceptor checkTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)  // 设置拦截器
                // 设置拦截规则
                .addPathPatterns("/shopcart/**")
                .addPathPatterns("/orders/**")
                .excludePathPatterns("/user/**");
    }
}
