package com.todo.imple.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo.imple.todo.service.TodoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	String home(Model model, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
		
		String todoList = todoService.mainTodoList(userDetails.getUsername());
		
		System.out.println(todoList);
		model.addAttribute("pong", "pong!");
		model.addAttribute("todoList", todoList);
		
		/*"""
		{
			title: "발표준비",
            start: "2023-06-22T00:00:00",
            end: "2023-06-24T00:00:00"
		},
		{
			title: "Spring Project",
            start: "2023-06-12",
            end: "2023-06-24"
        },
        {
      	    title: "발표",
            start: "2023-06-23T09:30:00",
            end: "2023-06-23T10:30:00"
        }
		"""*/
		return "main";
	}
}
