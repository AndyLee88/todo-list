package com.todo.imple.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.imple.user.mapper.UserMapper;
@SpringBootTest
class UserSignServiceTest {

	@Autowired
	UserMapper mapper;
	
	@Test
	void test() {
		//System.out.println(mapper.selectByUsername("java"));
		System.out.println(mapper.selectByUsers());
	}

}
