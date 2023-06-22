package com.todo.imple.todo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.todo.imple.todo.mapper.TodoDetailsMapper;
import com.todo.imple.todo.mapper.TodoTitlesMapper;
import com.todo.imple.todo.model.TodoJson;
import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.user.model.UsersDTO;
import com.todo.imple.user.service.UserManageService;

@Service
public class TodoService {
	@Autowired
	TodoTitlesMapper tTitlesMapper;
	
	@Autowired
	TodoDetailsMapper tDetailMapper;

	@Autowired
	UserManageService manageService;
	
	public Integer createTodo(TodoTitlesDTO dto, UserDetails userDetails) {
		
		UsersDTO users = manageService.selectByUsername(userDetails.getUsername());
    	dto.setIdno(users.getIdno());
		return tTitlesMapper.insertTodoTitles(strToDate(dto));
	}
	
	public TodoTitlesDTO strToDate(TodoTitlesDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if(dto.getTodoDueDateStr() != null && dto.getTodoDueDateStr() != "")
			dto.setTodoDueDate(LocalDateTime.parse(dto.getTodoDueDateStr(), formatter));
		
		if(dto.getTodoStartAtStr() != null && dto.getTodoStartAtStr() != "")
			dto.setTodoStartAt(LocalDateTime.parse(dto.getTodoStartAtStr(), formatter));
		
		if(dto.getTodoEndAtStr() != null && dto.getTodoEndAtStr() != "")
			dto.setTodoEndAt(LocalDateTime.parse(dto.getTodoEndAtStr(), formatter));
		return dto;
	}
	
	public String mainTodoList(String username) {
		//메인에 뿌려줄 todolist - json으로 파싱해서 리턴 할 것
		
		List<TodoJson> todo = tTitlesMapper.selectTodoTitiles(username);
		ObjectMapper mapper = new ObjectMapper();
		// 날짜/시간 모듈 추가
		mapper.registerModule(new JavaTimeModule());

		// 기본적으로 ISO_DATE_TIME 포맷 사용
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		// 날짜 형식 변경
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
		String returnJson = null;
		try {
			returnJson = mapper.writeValueAsString(todo);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		return returnJson;
	}
	
}
