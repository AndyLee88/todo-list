package com.todo.imple.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.service.TodoService;
import com.todo.standard.controller.DetailController;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/todo")
public class TodoDetailController implements DetailController<Integer> {
	@Autowired
	TodoService todoService;

	@Override
	public String detail(Integer key, Model model, HttpServletRequest request, UserDetails userDetails) {
		TodoTitlesDTO dto = todoService.getDetailTodo(key,userDetails.getUsername());
		model.addAttribute("e", dto);
		return  "todo/detail";
	}

	@Override
	public String detail(Integer key1, Integer key2, Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
