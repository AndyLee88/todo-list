package com.todo.standard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface DeleteController<DTO, T> {
	
	@DeleteMapping("/delete/{key}")
	ResponseEntity<?> delete(@PathVariable T key, Model model, HttpServletRequest request);
	
	@PostMapping("/delete")
	String delete(@Valid DTO dto, BindingResult binding, Model model, HttpServletRequest request, RedirectAttributes attr);
}
