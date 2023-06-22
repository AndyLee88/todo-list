package com.todo.imple.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.service.TodoService;
import com.todo.standard.controller.CreateController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoCreateController implements CreateController<TodoTitlesDTO> {
	
	@Autowired
	TodoService todoService;
	
	@Override
	public void create(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	public String create(@Valid TodoTitlesDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr, @AuthenticationPrincipal UserDetails userDetails) {
		todoService.createTodo(dto, userDetails);
		return "redirect:/";
	}
}
