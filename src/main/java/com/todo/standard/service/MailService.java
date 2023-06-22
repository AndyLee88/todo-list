package com.todo.standard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.imple.user.service.UserManageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	@Autowired
	UserManageService uService;
	/*@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "leeko19888@gmail.com";
	
	public void forgotPasswordMailSend(UsersDTO udto) {
		UsersDTO u = uService.selectByForgotPassword(udto);
		
		MailDTO mdto = new MailDTO();
		if(u != null) {
	    	mdto.setAddress(u.getEmail());
	    	mdto.setMessage("http://192.168.30.230:7707/user/forgot/"+u.getUsername());
	    	mailSend(mdto);
		}
	}*/
    
	/*public void mailSend(MailDTO dto) {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(dto.getAddress());
	    message.setFrom(MailService.FROM_ADDRESS);
	    message.setSubject(dto.getTitle());
	    message.setText(dto.getMessage());
	
	    mailSender.send(message);
	}*/
}