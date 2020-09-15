package com.tcsoft.gateway.utils;

import com.tcsoft.gateway.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;


/**
 * Jwt秘钥的生成和解析
 * @author big_john
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String CLAIM_KEY_USER_ID = "userId";
    private static final String CLAIM_KEY_USERNAME = "username";
    private static final String CLAIM_KEY_GROUP_ID = "groupId";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    /**
     * 获取token过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public JwtUser getJwtUser(String token){
        Claims claims = getClaimsFromToken(token);
        if (claims == null){
            return null;
        }else {
            JwtUser jwtUser = new JwtUser();
            jwtUser.setUserId((int)claims.get(CLAIM_KEY_USER_ID));
            jwtUser.setUsername((String)claims.get(CLAIM_KEY_USERNAME));
            jwtUser.setGroupId((int)claims.get(CLAIM_KEY_GROUP_ID));
            return jwtUser;
        }
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 查看token是否过期
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        if (expiration == null){
            return false;
        }
        return expiration.before(new Date());
    }

}

