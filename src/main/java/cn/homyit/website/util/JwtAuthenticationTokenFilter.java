package cn.homyit.website.util;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author 州牧 token拦截器
 * @description 解析token
 */
@Component
public class JwtAuthenticationTokenFilter implements HandlerInterceptor {

    @Autowired
    private RedisCache redisCache;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // OPTIONS请求不做校验,
        // 前后端分离的架构, 前端会发一个OPTIONS请求先做预检, 对预检请求不做校验
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            return true;
        }

        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //非token键
            return false;
        }
        //解析token
        String studentNumber;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            studentNumber = claims.getSubject();
        } catch (Exception e) {
            //token解析异常
            return false;
        }
        //从redis中获取用户信息
        String redisKey = "office-web:" + studentNumber;
        Object cacheObject = redisCache.getCacheObject(redisKey);
        if(Objects.isNull(cacheObject)){
            //过期token
            return false;
        }
        //放行
        return true;
    }
}