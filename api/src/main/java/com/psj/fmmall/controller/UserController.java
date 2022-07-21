package com.psj.fmmall.controller;

import com.psj.fmmall.entity.Users;
import com.psj.fmmall.service.UserService;
import com.psj.fmmall.utils.Base64Utils;
import com.psj.fmmall.vo.ResultVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author psj
 * @date 2022/7/16 23:06
 * @File: UserController.java
 * @Software: IntelliJ IDEA
 */
@RestController // 因为返回的都是json对象不是页面，本来每个控制器方法都要加上@ResponseBody,直接在类上加RestController即可
@RequestMapping("/user")
// 用于生成swagger文档中的注释(@ApiOperation和@ApiImplicitParams也是)
@Api(value = "提供用户的登录和注册接口", tags = "用户管理")
@CrossOrigin  // 设置允许跨域
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户登录账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户登录密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam(value = "password") String pwd) {
        ResultVO resultVO = userService.checkLogin(name, pwd);

        return resultVO;
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户注册账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户注册密码", required = true)
    })
    @PostMapping("/regist")
    public ResultVO regist(@RequestBody Users user) {
        return userService.userRegist(user.getUsername(), user.getPassword());
    }
}
