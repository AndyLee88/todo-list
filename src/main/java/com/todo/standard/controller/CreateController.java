package com.todo.standard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface CreateController<DTO> {
	
	@GetMapping("/create")
	void create(Model model, HttpServletRequest request);
	
	@PostMapping("/create")
	String create(@Valid DTO dto, BindingResult binding, Model model, HttpServletRequest request, RedirectAttributes attr, @AuthenticationPrincipal UserDetails userDetails);

}
