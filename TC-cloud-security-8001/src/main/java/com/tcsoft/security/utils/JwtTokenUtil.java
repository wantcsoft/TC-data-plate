package com.tcsoft.security.utils;

import com.tcsoft.security.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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
    private static final String CLAIM_KEY_ROLE = "role";
    private static final String CLAIM_KEY_LAST_PASSWORD = "lastPasswordResetDate";
    private static final String CLAIM_KEY_ACCOUNT_LOCKED = "accountNonLocked";
    private static final String CLAIM_KEY_ACCOUNT_EXPIRED = "accountNonExpired";
    private static final String CLAIM_KEY_CREDENTIAL_EXPIRED = "credentialsNonExpired";
    private static final String CLAIM_KEY_ENABLED = "enabled";


    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = (String)claims.get(CLAIM_KEY_USERNAME);
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 获取token创建的时间
     * @param token
     * @return
     */
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

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
            return new JwtUser((int)claims.get(CLAIM_KEY_USER_ID),
                    (String) claims.get(CLAIM_KEY_USERNAME),
                    "",
                    (int)claims.get(CLAIM_KEY_GROUP_ID),
                    AuthorityUtils.commaSeparatedStringToAuthorityList((String)claims.get(CLAIM_KEY_ROLE)),
                    new Date((Long) claims.get(CLAIM_KEY_LAST_PASSWORD)),
                    (boolean)claims.get(CLAIM_KEY_ACCOUNT_LOCKED),
                    (boolean)claims.get(CLAIM_KEY_ACCOUNT_EXPIRED),
                    (boolean)claims.get(CLAIM_KEY_CREDENTIAL_EXPIRED),
                    (boolean)claims.get(CLAIM_KEY_ENABLED));
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
     * 设置token过期的时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
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

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    /**
     * 根据用户信息生成token
     * @param user
     * @return
     */
    public String generateToken(JwtUser user) {
        Map<String, Object> claims = new HashMap<>(9);
        claims.put(CLAIM_KEY_USER_ID, user.getUserId());
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_GROUP_ID, user.getGroupId());
        StringBuilder role = new StringBuilder();
        user.getAuthorities().forEach((x) -> role.append(x.toString()).append(","));
        claims.put(CLAIM_KEY_ROLE, role);
        claims.put(CLAIM_KEY_LAST_PASSWORD, user.getLastPasswordResetDate());
        claims.put(CLAIM_KEY_ACCOUNT_LOCKED, user.isAccountNonLocked());
        claims.put(CLAIM_KEY_ACCOUNT_EXPIRED, user.isAccountNonExpired());
        claims.put(CLAIM_KEY_CREDENTIAL_EXPIRED, user.isCredentialsNonExpired());
        claims.put(CLAIM_KEY_ENABLED, user.isEnabled());
        claims.put(CLAIM_KEY_CREATED, new Date(System.currentTimeMillis()));
        return generateToken(claims);
    }

    /**
     * token加密
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    //密码修改后需要刷新token
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }
    //获取刷新后的token
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }
    //token过期锁定启用
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
//        final Date expiration = getExpirationDateFromToken(token);
        boolean flag1 = username.equals(user.getUsername());
        boolean flag2 = !isTokenExpired(token);
        boolean flag3 = !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate());
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
    }
}

