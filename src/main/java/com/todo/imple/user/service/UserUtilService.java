package com.todo.imple.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.imple.user.model.UsersDTO;

@Service
public class UserUtilService {

    public UsersDTO mobileToMob(UsersDTO dto) {
    	if(dto != null && dto.getMobile()!= null) {
    	String[] mobs = dto.getMobile().split("-");
    	dto.setMob1(mobs[0]);
    	dto.setMob2(mobs[1]);
    	dto.setMob3(mobs[2]);
    	}
    	return dto;
    }
    public UsersDTO mobToMobile(UsersDTO dto) {
    	if(dto != null && dto.getMob1()!= null && dto.getMob2()!= null && dto.getMob3()!= null) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(dto.getMob1()).append('-');
    	sb.append(dto.getMob2()).append('-');
    	sb.append(dto.getMob3());
    	if(sb.length() <= 3) {
    		sb.append("010-0000-0000");
    	}
    	dto.setMobile(sb.toString());
    	}
    	return dto;
    }
    public String passwordEncoder(String password) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	return encoder.encode(password);
    }
}
