package com.example.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repositry.UserRepositort;

@Service
public class customUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        User user = userRepo.findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                .orElseThrow(()-> new UsernameNotFoundException
                        ("user not found with Username or Email!"+
                                usernameOrEmail));
        org.springframework.security.core core = new org.springframework.security.core.(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles())); return core;
    }


    private Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority
                (role.get)).collect(Collectors.toList());
    }

}

