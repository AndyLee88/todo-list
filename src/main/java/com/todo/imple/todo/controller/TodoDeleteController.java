package com.todo.imple.todo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.service.TodoService;
import com.todo.standard.controller.DeleteControllerPost;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoDeleteController implements DeleteControllerPost<TodoTitlesDTO> {

	@Autowired
	TodoService todoService; 
	
	@Override
	public void delete(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(@Valid TodoTitlesDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteIdxs(@Valid TodoTitlesDTO dto, BindingResult binding, Model model, HttpServletRequest request,
			RedirectAttributes attr, UserDetails userDetails, @RequestParam String idxs) {
		//추후에  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("idxs parameter is missing or empty");로 변경 필요
		if(idxs==null || idxs.equals(""))
			return "redirect:/todo/list";
		
		List<String> idxList = Arrays.asList(idxs.split("\\s+")); // 공백으로 split
        todoService.deleteByIdxs(idxList, userDetails.getUsername());
        
        return "redirect:/todo/list";
	}



}
