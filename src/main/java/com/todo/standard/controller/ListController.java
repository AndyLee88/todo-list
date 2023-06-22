package com.todo.standard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

public interface ListController {

	@GetMapping("/list")
	void list(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request);
}
