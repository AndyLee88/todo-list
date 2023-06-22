package com.todo.imple.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.service.TodoService;
import com.todo.standard.controller.ListController;
import com.todo.standard.controller.PageableController;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/todo")
public class TodoListController implements ListController, PageableController {
	@Autowired
	TodoService todoService;

	@Override
	public void list(Model model, UserDetails userDetails, HttpServletRequest request) {
		List<TodoTitlesDTO> dto = todoService.getTodoList(userDetails.getUsername());
		model.addAttribute("todolist", dto);
	}

	@Override
	public String page(int pageNum, int pageSize, Model model, UserDetails userDetails) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TodoTitlesDTO> list = todoService.getTodoListPage(userDetails.getUsername());
		var paging = PageInfo.of(list, 10);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		return "todo/page";
	}

}
