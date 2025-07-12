package com.study.lease.web.admin.custom.interceptor;

import com.study.lease.common.exception.LeaseException;
import com.study.lease.common.login.LoginUser;
import com.study.lease.common.login.LoginUserHolder;
import com.study.lease.common.result.ResultCodeEnum;
import com.study.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: AuthenticationInterceptor
 * Package: com.study.lease.web.admin.custom.interceptor
 * Description:
 *
 * @Author pupil
 * @Create 2025/5/5 17:58
 * @Version 1.0
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("access-token");
        Claims claims = JwtUtil.parseToken(token);
        Long userId=claims.get("userId",Long.class);
        String username=claims.get("username",String.class);
        LoginUserHolder.setLoginUser(new LoginUser(userId,username));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
