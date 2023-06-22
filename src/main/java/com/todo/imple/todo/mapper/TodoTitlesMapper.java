package com.todo.imple.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.todo.imple.todo.model.TodoJson;

@Mapper
public interface TodoTitlesMapper {
	
	String selectTodoTitiles = """
			SELECT TITLE, TODO_START_AT, TODO_END_AT
		    FROM TODO_TITLES
		    WHERE IDNO IN (
		        SELECT IDNO
		        FROM USERS
		        WHERE USERNAME = #{username}
		    )
			""";
	@Select(selectTodoTitiles)
	@Results({
	    @Result(property = "title", column = "TITLE"),
	    @Result(property = "start", column = "TODO_START_AT"),
	    @Result(property = "end", column = "TODO_END_AT")
	})
	List<TodoJson> selectTodoTitiles(String username);
	
	String insertTodoTitles= """
			INSERT INTO TODO_TITLES (TITLE, DESCRIPTION, STATUS, TODO_START_AT, TODO_END_AT, TODO_DUE_DATE, IMPORTANCE, IDNO)
			values ( 
			 	#{todo.title,  jdbcType=VARCHAR}, 
			 	#{todo.description, 	jdbcType=VARCHAR},
			 	#{todo.status, 	jdbcType=VARCHAR},
			 	#{todo.todoStartAt, 	jdbcType=DATE},
			 	#{todo.todoEndAt, 	jdbcType=DATE},
			 	#{todo.todoDueDate, 	jdbcType=DATE},
			 	#{todo.importance},
			 	#{todo.idno}
			) 
			""";
	//@Options(useGeneratedKeys = true, keyProperty = "tdtino")
	@Insert(insertTodoTitles)
	Integer insertTodoTitles(@Param("todo")TodoTitlesDTO todoDetailsDTO);
	
	
}
