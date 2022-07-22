package com.psj.fmmall.service.impl;

import com.psj.fmmall.dao.UsersMapper;
import com.psj.fmmall.entity.Users;
import com.psj.fmmall.service.UserService;
import com.psj.fmmall.utils.Base64Utils;
import com.psj.fmmall.utils.MD5Utils;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author psj
 * @date 2022/7/16 22:58
 * @File: UserServiceImpl.java
 * @Software: IntelliJ IDEA
 */
@Service
//@Scope("singleton")  // 让不同的线程执行到该方法时,UserServiceImpl只有一个对象(spring容器默认单例，可以不加)
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    @Transactional  // 可能会出现多线程操作:一个线程填写了信息校验通过(即user==null)，另一个线程做了相同的操作且先进行了注册
    public ResultVO userRegist(String name, String pwd) {
        synchronized (this) {  // spring默认单例,所以可以使用实例锁this
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", name);
            List<Users> users = usersMapper.selectByExample(example);

            // 1.根据用户信息查询该用户是否被注册
            if (users.size() == 0) {
                // 将密码进行MD5加密
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败", null);

                }
            } else {
                return new ResultVO(ResStatus.NO, "用户名已经被注册", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String pwd) {
        // 1.根据用户名查询用户
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = usersMapper.selectByExample(example);

        // 2.判断用户是否存在
        if (users.size() == 0) {
            // 用户名不存在
            return new ResultVO(ResStatus.NO, "登录失败,用户名不存在", null);  // 1表示失败的状态码
        } else {
            // 对输入的密码进行加密再进行校验
            String md5Pwd = MD5Utils.md5(pwd);
            // 使用加密后的密码和user中的密码进行匹配
            if (md5Pwd.equals(users.get(0).getPassword())) {
                // 如果登录成功,需要先生成令牌token(即按照特定规则生成的字符串)
//                String token = Base64Utils.encode(name + "psj");  // 使用Base64算法加密,安全性较低且不具备时效性

                Map<String, Object> map = new HashMap<>();
                JwtBuilder builder = Jwts.builder();
                String token = builder.setSubject(name)  // 设置token中携带的数据
                        .setIssuedAt(new Date())  // 设置token的生成时间,用于过期校验
                        .setId(users.get(0).getUserId() + "")  // 设置用户id为token的id
                        .setClaims(map)  // map中存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))  // 设置token过期时间(1天)
                        .signWith(SignatureAlgorithm.HS256, "pengshijie")  // 设置加密方式和加密的密码(密码设置过短会报错)
                        .compact();
                return new ResultVO(ResStatus.OK, token, users.get(0));
            } else {
                // 密码错误
                return new ResultVO(ResStatus.NO, "登录失败,密码错误", null);
            }
        }
    }
}
