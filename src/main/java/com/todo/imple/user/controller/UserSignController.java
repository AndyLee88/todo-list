package com.todo.imple.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.imple.user.model.UsersDTO;
import com.todo.imple.user.service.UserSignService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserSignController {
	
	@Autowired
	UserSignService signservice;
	
	@GetMapping("signup")
    String signup() {

        return "user/signUp/signUpStep1";
    }
	@GetMapping("checkid/{key}")
	ResponseEntity<String> checkid(@PathVariable String key) {
		if(key == null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("비정상적인 접근입니다.");
		String[] keys = key.split(":");
		String username = keys[0];
		if(!"32".equals(keys[1]))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("비정상적인 접근입니다.");
		try {
			Integer resultCount = signservice.duplicateUserName(username);
			if(resultCount < 1)	
			    return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("기타오류 : 개발부에 문의하세요");
	    }
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미 사용중인 아이디입니다");
    }
	
	@PostMapping("signup")
	public ResponseEntity<String> signStep1(@ModelAttribute(value="dto") @Valid UsersDTO dto) {
		
		String result = signservice.registionUser(dto);
		if (result.equals("error")) {
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("가입에 실패했습니다. 관리자에 문의하세요.");
		} else {
		    return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}
	@GetMapping("signup-end/{key}")
    String signStep2(@PathVariable Integer key, Model model, HttpServletRequest request) {
		UsersDTO users = signservice.selectByNewIdno(key);
		if(users != null) {
			model.addAttribute("users", users);
			model.addAttribute("error", "success");
		}else {
			model.addAttribute("error", "error");
			model.addAttribute("users", null);
		}
        return "user/signUp/signUpStep2";
    }

}
