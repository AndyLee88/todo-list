package com.todo.standard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PageableController {

	@GetMapping("/page/{pageNum}/{pageSize}")
	String page(@PathVariable int pageNum, @PathVariable int pageSize, Model model, @AuthenticationPrincipal UserDetails userDetails);
}
