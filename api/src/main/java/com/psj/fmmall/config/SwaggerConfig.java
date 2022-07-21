package com.psj.fmmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author psj
 * @date 2022/7/18 10:51
 * @File: SwaggerConfig.java
 * @Software: IntelliJ IDEA
 */
// Swagger的配置类(因为不属于SpringBoot管理的依赖，所以需要自己进行配置)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
        1.配置生成的文档信息
        2.配置生成规则
     */

    @Bean
    /* Docket封装接口文档信息 */
    public Docket getDocket() {

        /* 如何获取一个接口/抽象类的对象
            1.new 接口(意味着需要实现接口中的所有抽象方法)
            2.new 子类/实现类
            3.使用工厂模式
         */
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder(); // 工厂
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                .description("说明商城项目后端接口规范")
                .version("v 2.0.1")
                .contact(new Contact("psj", "www.psj.com", "729589165@qq.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)  // 指定文档风格
                .apiInfo(apiInfo)  // 指定生成的文档中的封面信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.psj.fmmall.controller"))  // 指定对哪个包生成接口文档
                .paths(PathSelectors.any())  // 表示为包中所有请求产生文档
                .build();

        return docket;
    }
}
