package com.psj.fmmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 因为启动后会扫描当前启动类所在包下所有子包(可以多级)，当前所在包为com.psj，所以com.psj.xxx会被扫描到
// 因为api已经通过依赖service间接依赖了mapper和beans，所以为了保证mapper的dao和beans中entity能被springBoot扫描到
// dao和entity的所在包的路径要为com.psj.xxx
@MapperScan("com.psj.fmmall.dao")  // 注意换成tk.mybatis包下的
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
