package com.todo.imple.user.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.imple.user.mapper.UserMapper;

@Service
public class UserLoginService  implements UserDetailsService {

    @Autowired
    UserMapper mapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = mapper.selectByUsername(username);
        if (Objects.isNull(user))
            throw new UsernameNotFoundException("없는 회원입니다");

        return User.builder()
                   .username(user.getUsername())
                   .password(user.getPassword())
                   .roles(user.getRole())
                   .build();
    }

}