package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.base.SysUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/13 21:08
 * @Description
 */
public class JWTUtil {

    private static  final long EXPIRE = 30*60*1000L;
    // token 秘钥
    private static final String SECRET = "jwt";

    public static  String createToken(SysUser sysUser)  {
        Date date = new Date(System.currentTimeMillis() + EXPIRE);

        // jwt 的header 部分
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("type","JWT");

        // 使用jwt 的api生成
        String token = JWT.create()
                .withHeader(map)
                .withClaim("user", JSON.toJSONString(sysUser))
                .withExpiresAt(date) // 过期时间
                .withIssuedAt(new Date()) // 签发时间
                .sign(Algorithm.HMAC256(SECRET)); // 签名
        return token;
    }

    /**
     * 校验token 的有效性
     * @param token token的header和payload是否有改动过  2 是否过期
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    public static SysUser getUserInfo(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String userInfo =    jwt.getClaim("user").asString();
            return JSON.parseObject(userInfo,SysUser.class);
        } catch (JWTDecodeException ex) {
            return  null;
        }
    }



}
