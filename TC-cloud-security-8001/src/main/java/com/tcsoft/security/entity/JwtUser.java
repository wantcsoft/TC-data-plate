package com.tcsoft.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;


/**
 * UserDetails实现类，给spring security使用
 * @author big_john
 */
public class JwtUser implements UserDetails {
    private final Integer UserId;
    private final String username;
    private final String password;
    private final Integer groupId;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;
    private final boolean accountNonLocked;
    private final boolean accountNonExpired;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

    public JwtUser(
            Integer UserId,
            String username,
            String password,
            Integer groupId,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate,
            boolean accountNonLocked,
            boolean accountNonExpired,
            boolean credentialsNonExpired,
            boolean enabled) {
        this.UserId = UserId;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public Integer getId() {
        return UserId;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public Integer getGroupId(){
        return groupId;
    }

    /**
     * 账户是否过期
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
