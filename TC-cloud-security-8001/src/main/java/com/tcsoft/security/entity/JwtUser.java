package com.tcsoft.security.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

}
