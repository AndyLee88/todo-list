package com.todo.imple.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;


public class UserPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println("rawPassword = " + rawPassword);
        System.out.println("encodedPassword = " + encodedPassword);
        return encodedPassword.equals(encode(rawPassword));
    }

}
