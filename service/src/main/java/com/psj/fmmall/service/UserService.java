package com.psj.fmmall.service;

import com.psj.fmmall.vo.ResultVO;

/**
 * @author psj
 * @date 2022/7/16 22:57
 * @File: UserService.java
 * @Software: IntelliJ IDEA
 */
public interface UserService {

    // 用户注册(注册页面只要输入两个值)
    public ResultVO userRegist(String name, String pwd);

    // 用户登录
    public ResultVO checkLogin(String name, String pwd);
}
