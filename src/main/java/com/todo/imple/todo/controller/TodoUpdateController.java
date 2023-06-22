package com.todo.imple.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.service.TodoService;
import com.todo.imple.user.model.UsersDTO;
import com.todo.imple.user.service.UserManageService;
import com.todo.standard.controller.UpdateController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoUpdateController implements UpdateController<TodoTitlesDTO, Integer> {

	@Autowired
	UserManageService manageService;
	@Autowired
	TodoService todoService; 
	
	@Override
	public String update(Integer key, Model model, HttpServletRequest request) {
		// todo 수정 페이지
		return null;
	}

	@Override
	public String update(@Valid TodoTitlesDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr, UserDetails userDetails) {
		UsersDTO users = manageService.selectByUsername(userDetails.getUsername());
		todoService.updateDetailTodo(dto, users.getIdno());
    	return "redirect:/todo/detail/"+dto.getTdtino().toString();
	}
}
