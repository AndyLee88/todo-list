package com.todo.imple.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.imple.user.mapper.UserMapper;
import com.todo.imple.user.model.UsersDTO;

@Service
public class UserSignService{

    @Autowired
    UserMapper mapper;
    
    @Autowired
    UserUtilService utilService;

	@Transactional
    public String  registionUser(UsersDTO dto){
		dto = utilService.mobToMobile(dto);
		dto.setPassword(utilService.passwordEncoder(dto.getPassword2()));
		
        if(mapper.insertByNewUsers(dto) > 0)
        	return mapper.selectByUsername(dto.getUsername()).getIdno().toString();
        else
        	return "error";
    }
    
    public UsersDTO selectByNewIdno(Integer idno){
    	UsersDTO dto = mapper.selectByNewIdno(idno);
        return utilService.mobileToMob(dto);
    }
    
    public Integer duplicateUserName(String username){
        return mapper.selectSameUsername(username);
    }

}