package com.psj.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author psj
 * @date 2022/7/21 23:43
 * @File: CheckTokenInterceptor.java
 * @Software: IntelliJ IDEA
 */

/**
 * token校验的拦截器
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在正式传递数据前会有一个预检请求,请求方式为OPTIONS
        String method = request.getMethod();
        // 遇到预检请求就不进行处理
        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;
        }
        // 此时的请求为正式请求
        String token = request.getHeader("token");  // token使用请求头传递(如果使用请求体传递token就不需要判断预检请求)
        if (token == null) {
            ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录!", null);
            // 提示请先登录
            doResponse(response, resultVO);
        } else {
            try {
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("pengshijie");  // 解析token的SigningKey必须和生成token时设置的密码一致
                // 如果token的密码正确且在有效期内，则正常执行;否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "登录过期,请重新登录!", null);
                doResponse(response, resultVO);
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "token不合法!", null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录!", null);
                doResponse(response, resultVO);
            }
        }
        return false;  // 捕获到异常后最终会执行到该步骤
    }

    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);  // 将对象转换为json
        out.print(s);
        out.flush();
        out.close();
    }
}
