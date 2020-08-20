package com.tcsoft.security.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;


/**
 * UserDetails实现类，给spring security使用
 * @author big_john
 */
@Data
@NoArgsConstructor
public class JwtUser implements UserDetails {
    private  Integer userId;
    private  String username;
    private  String password;
    private  Integer groupId;
    private  Collection<? extends GrantedAuthority> authorities;
    private  Date lastPasswordResetDate;
    private  boolean accountNonLocked;
    private  boolean accountNonExpired;
    private  boolean credentialsNonExpired;
    private  boolean enabled;

    public JwtUser(
            Integer userId,
            String username,
            String password,
            Integer groupId,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate,
            boolean accountNonLocked,
            boolean accountNonExpired,
            boolean credentialsNonExpired,
            boolean enabled) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.groupId = groupId;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

}
