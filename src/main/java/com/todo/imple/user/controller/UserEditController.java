package com.todo.imple.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.imple.user.model.UsersDTO;
import com.todo.imple.user.service.UserManageService;
import com.todo.standard.service.MailService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserEditController {

	@Autowired
	UserManageService manageService;
	@Autowired
	MailService mailService;
	
    @GetMapping("edit")
    String edit(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    	UsersDTO users = manageService.selectByUsername(userDetails.getUsername());
    	model.addAttribute("users", users);
    	return "user/edit/editUser";
    }
    @PostMapping("update")
	public ResponseEntity<String> userUpdate(@ModelAttribute(value="dto") @Valid UsersDTO dto) {
		
		Integer result = manageService.updateUser(dto);
		if(result>0)
			return ResponseEntity.ok("수정 완료");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("정보를 갱신할 수 없습니다.");
	}
    @GetMapping("forgot/{key}")
    public String findPassword(@PathVariable String key, Model model) {
    	UsersDTO user = manageService.selectByUsername(key);
		model.addAttribute("users", user);
    	return "user/edit/editUser";
	}

    @GetMapping("manage")
    String manage() {

        return "user/edit/manageList";
    }
    
    @GetMapping("forgot-password")
    String forgotPassword() {
        return "user/edit/forgotPassword";
    }
    
    @PostMapping("forgot-password")
    String forgotPassword(UsersDTO dto) {
		/*mailService.forgotPasswordMailSend(dto);*/
        return "user/edit/forgotPassword";
    }
    

}
