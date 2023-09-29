package com.exampro.config;

import com.exampro.model.User;
import com.exampro.utils.jwt.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;


public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractTokenFromRequest(request);

        if (token != null) {
            // 根据令牌验证用户身份
            Authentication authentication = validateTokenAndGetAuthentication(token);

            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    // 从请求中提取令牌
    private String extractTokenFromRequest(HttpServletRequest request) {
        // 实现从请求头或请求参数中提取令牌的逻辑
        // 这里需要根据你的实际令牌传递方式来编写代码
        // 例如，从请求头中提取：String token = request.getHeader("Authorization");
        // 或者从请求参数中提取：String token = request.getParameter("token");
        return request.getHeader("Authorization");
    }

    // 根据令牌验证用户身份
    private Authentication validateTokenAndGetAuthentication(String token) {
        // 实现验证令牌并获取用户身份的逻辑
        // 验证成功返回包含用户信息的Authentication对象，验证失败返回null
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        Claims claims = jwtTokenUtil.parseToken(token);
        // claims
        Date expirationDate = claims.getExpiration();
        Date currentDate = new Date();
        System.out.println("过期时间"+expirationDate);
        System.out.println("当前时间"+currentDate);
        if (currentDate.before(expirationDate)) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(new User(Integer.parseInt(claims.getId()), claims.getSubject()));
    }
}

