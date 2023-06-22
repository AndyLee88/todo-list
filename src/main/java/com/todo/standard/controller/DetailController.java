package com.todo.standard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;

public interface DetailController<T> {

	@GetMapping("/detail/{key}")
	String detail(@PathVariable T key, Model model, HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails);
	
	@GetMapping("/detail/{key1}/{key2}")
	String detail(@PathVariable T key1,@PathVariable T key2, Model model, HttpServletRequest request);
}
