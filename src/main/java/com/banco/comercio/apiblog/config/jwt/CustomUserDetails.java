package com.banco.comercio.apiblog.config.jwt;


import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;

    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    public static CustomUserDetails buildUser(UserEntity user) {
        List<SimpleGrantedAuthority> roles= user.getRoles().stream().map(x -> new SimpleGrantedAuthority(x.getName())).toList();
        return CustomUserDetails.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(roles).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().toList();


    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
