package com.ycc.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

/**
 * @author ycc
 */
public class UserProvider implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s+"..........");
//        AuthorityUtils.createAuthorityList(new String[]{"vip"});
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("vip");
        return new User("zs","12",auths);
    }
}
