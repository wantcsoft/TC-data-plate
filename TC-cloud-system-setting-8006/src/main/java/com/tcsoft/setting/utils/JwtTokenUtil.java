package com.tcsoft.setting.utils;


import com.tcsoft.setting.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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


}

