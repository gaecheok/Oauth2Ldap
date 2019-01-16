package com.example.oauth2auth.config;

import com.example.oauth2auth.service.DefaultUserDetailsService;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class LdapAuthoritiesPopulator implements org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator {


    private DefaultUserDetailsService userService;

    public LdapAuthoritiesPopulator(DefaultUserDetailsService userService) {
        this.userService = userService;
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(
            DirContextOperations userData, String username) {

        Collection<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        //userService 와 연계된 DB 등 에서 권한정보를 가져다가 이곳에서 리턴해주면 됨.
        //authorities.addAll(userService.getAuthorities(username));

        return authorities;
    }
}
