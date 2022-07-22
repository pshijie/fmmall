package com.psj.fmmall.controller;

import com.psj.fmmall.utils.Base64Utils;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author psj
 * @date 2022/7/21 11:57
 * @File: ShopcartController.java
 * @Software: IntelliJ IDEA
 */
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "提供购物车业务相关接口", tags = "购物车管理")
public class ShopcartController {

    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "token", value = "授权令牌", required = true)
    })
    @GetMapping("/list")
    public ResultVO listCarts() {
        // --------------未使用拦截器---------------
//        // 校验token
//        if (token == null) {
//            return new ResultVO(ResStatus.NO, "请先登录", null);
//        } else {
//            // 使用Base64算法加密,安全性较低且不具备时效性
////            String decode = Base64Utils.decode(token);
////            if (decode.endsWith("psj")) {
////                // token校验成功
////                return new ResultVO(ResStatus.OK, "success", null);
////            } else {
////                return new ResultVO(ResStatus.NO, "登录已过期,请重新登录", null);
////            }
//
//            // 使用JWT但不使用拦截器实现
//            try {
//                JwtParser parser = Jwts.parser();
//                parser.setSigningKey("pengshijie");  // 解析token的SigningKey必须和生成token时设置的密码一致
//                // 如果token的密码正确且在有效期内，则正常执行;否则抛出异常
//                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
//                return new ResultVO(ResStatus.OK, "success", null);
//            } catch (ExpiredJwtException e) {
//                return new ResultVO(ResStatus.NO, "登录已过期,请重新登录", null);
//            } catch (UnsupportedJwtException e) {
//                return new ResultVO(ResStatus.NO, "Token不合法", null);
//            } catch (Exception e) {
//                return new ResultVO(ResStatus.NO, "请重新登录", null);
//            }
//        }
        // --------------未使用拦截器---------------

        // 使用了拦截器后直接写具体业务代码即可
        return new ResultVO(ResStatus.OK, "success", null);
    }
}
