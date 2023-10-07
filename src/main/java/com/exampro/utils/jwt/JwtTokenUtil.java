package com.exampro.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author pluto
 */
@Component
public class JwtTokenUtil {
    /**
     * 密钥
     */
    private String secret = "examprohahaha";
    /**
     * Token的过期时间，单位秒
     */
    private Long ttl = 24 * 3600L * 1000; // 设置为24小时


    /**
     * 生成Token
     * @param userId
     * @param userName
     * @return
     */

    public String buildToken(int userId, String userName, int role) {
        /**
         * 当前系统时间
         */
        long currentTimeMillis = System.currentTimeMillis();

        /**
         * 过期时间(24h)
         */
        long expirationTimeMillis = currentTimeMillis + ttl;

        /**
         * 指定加密算法和密钥
         * 添加载荷部分键值对 => 放置登录用户id
         * 添加载荷部分键值对 => 放置登录用户名
         * 添加载荷部分键值对 => 放置签发token时间
         * 指定token的过期时间
         * 生成密文token
         */
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setId(userId+"")
                .setSubject(userName)
                .setAudience(role+"")
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationTimeMillis))
                .compact();
        return token;
    }

    /**
     * 解析Token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        /**
         * 返回token解析器
         * 指定解析使用的密钥 => 需要跟加密时使用相同的密钥
         * 指定要解密的Token
         * 获得载荷部分
         */
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }


    /**
     * 测试jwt功能
     * @param args
     */
    public static void main(String[] args) {
        JwtTokenUtil jwtUtils = new JwtTokenUtil();
        String token = jwtUtils.buildToken(2,"zhhh",0);
        System.out.println(token);
        Claims claims = jwtUtils.parseToken(token);
        System.out.println(claims);
        System.out.println(claims.getSubject()); // 用户名
        System.out.println(claims.getId()); // 用户id
        System.out.println(claims.getAudience()); // 用户角色
    }
}
