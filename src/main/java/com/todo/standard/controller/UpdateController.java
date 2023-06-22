package com.todo.standard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface UpdateController<DTO, T> {
	
	@GetMapping("/update/{key}")
	String update(@PathVariable T key,Model model, HttpServletRequest request);
	
	@PostMapping("/update")
	String update(@Valid DTO dto, BindingResult binding, Model model, HttpServletRequest request, RedirectAttributes attr, @AuthenticationPrincipal UserDetails userDetails);

}
