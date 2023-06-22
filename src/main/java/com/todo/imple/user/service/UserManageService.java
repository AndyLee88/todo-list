package com.todo.imple.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.imple.user.mapper.UserMapper;
import com.todo.imple.user.model.UsersDTO;

@Service
public class UserManageService{

    @Autowired
    UserMapper mapper;
    
    @Autowired
    UserUtilService utilService;

    public UsersDTO selectByUsername(String username){
        return utilService.mobileToMob(mapper.selectByUsername(username));
    }
    
    @Transactional
    public UsersDTO selectByFogotUsername(String username){
        return utilService.mobileToMob(mapper.selectRecentUser(username));
    }
	
    public UsersDTO selectByIdno(Integer idno){
    	UsersDTO dto = mapper.selectByIdno(idno);
        return utilService.mobileToMob(dto);
    }
    
    @Transactional
    public UsersDTO selectByForgotPassword(UsersDTO dto){
    	UsersDTO u = mapper.selectByForgotPassword(dto);
    	if(u.getIdno() != null) {
    		mapper.insertByUsersHistory(u);
        	return u;
    	}else return null;
        
    }
    
    @Transactional
    public Integer updateUser(UsersDTO dto){
    	dto.setPassword(utilService.passwordEncoder(dto.getPassword2()));
    	dto = utilService.mobToMobile(dto);
    	Integer result = mapper.updateUsers(dto);
    	mapper.insertByUsersHistory(dto);
        return result; 
    }

}