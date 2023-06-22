package com.todo.imple.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.todo.imple.todo.model.TodoTitlesDTO;
import com.github.pagehelper.Page;
import com.todo.imple.todo.model.TodoJson;

@Mapper
public interface TodoTitlesMapper {
	
	String selectTodoTitiles = """
			SELECT TDTINO, TITLE, TODO_START_AT, TODO_END_AT
		    FROM TODO_TITLES
		    WHERE IDNO IN (
		        SELECT IDNO
		        FROM USERS
		        WHERE USERNAME = #{username}
		    )
			""";
	@Select(selectTodoTitiles)
	@Results({
		@Result(property = "url", column = "TDTINO"),
	    @Result(property = "title", column = "TITLE"),
	    @Result(property = "start", column = "TODO_START_AT"),
	    @Result(property = "end", column = "TODO_END_AT")
	})
	List<TodoJson> selectTodoTitiles(String username);
	
	String selectTodoList = """
			SELECT 
			tdtino,
			title, 
		    description, 
		    importance, 
		    TO_CHAR(todo_start_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_start_at_str, 
		    TO_CHAR(todo_end_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_end_at_str, 
		    TO_CHAR(todo_due_date, 'YYYY-MM-DD HH24:MI:SS') AS todo_due_date_str 
		    FROM TODO_TITLES
		    WHERE IDNO IN (
		        SELECT IDNO
		        FROM USERS
		        WHERE USERNAME = #{username}
		    )
			""";
	@Select(selectTodoList)
	List<TodoTitlesDTO> selectTodoList(String username);
	
	String selectDetailTodoList = """
			SELECT 
			TDTINO,
			title, 
		    description, 
		    importance, 
		    TO_CHAR(todo_start_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_start_at_str, 
		    TO_CHAR(todo_end_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_end_at_str, 
		    TO_CHAR(todo_due_date, 'YYYY-MM-DD HH24:MI:SS') AS todo_due_date_str 
		    FROM TODO_TITLES
		    WHERE TDTINO = #{tdtino}
			   	AND IDNO IN (
		        SELECT IDNO
		        FROM USERS
		        WHERE USERNAME = #{username}
		    )
			""";
	@Select(selectDetailTodoList)
	TodoTitlesDTO selectDetailTodoList(@Param("tdtino") Integer tdtino, @Param("username") String username);
	
	//TO_CHAR(todo_end_at, 'YYYY-MM-DD HH24:MI') AS todo_end_at_str,
	String selectTodoListPage = """
			SELECT 
			tdtino,
			title, 
		    description, 
		    importance, 
		    TO_CHAR(todo_start_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_start_at_str, 
		    TO_CHAR(todo_end_at, 'YYYY-MM-DD HH24:MI:SS') AS todo_end_at_str, 
		    TO_CHAR(todo_due_date, 'YYYY-MM-DD HH24:MI:SS') AS todo_due_date_str 
		    FROM TODO_TITLES
		    WHERE IDNO IN (
		        SELECT IDNO
		        FROM USERS
		        WHERE USERNAME = #{username}
		    )
			""";
	@Select(selectTodoListPage)
	Page<TodoTitlesDTO> selectTodoListPage(String username);
	
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
	
	String updateDetailTodo= """
			UPDATE TODO_TITLES
			SET TITLE = #{todo.title, jdbcType=VARCHAR},
			    DESCRIPTION = #{todo.description, jdbcType=VARCHAR},
			    STATUS = #{todo.status, jdbcType=VARCHAR},
			    TODO_START_AT = #{todo.todoStartAt, jdbcType=TIMESTAMP},
			    TODO_EDIT_AT = CURRENT_DATE,
			    TODO_END_AT = #{todo.todoEndAt, jdbcType=TIMESTAMP},
			    TODO_DUE_DATE = #{todo.todoDueDate, jdbcType=TIMESTAMP},
			    IMPORTANCE = #{todo.importance, jdbcType=INTEGER}
			WHERE TDTINO = #{todo.tdtino, jdbcType=INTEGER} 
			AND IDNO = #{idno}

			""";
	@Insert(updateDetailTodo)
	Integer updateDetailTodo(@Param("todo")TodoTitlesDTO todoDetailsDTO, @Param("idno") Integer idno);
	
	@Delete({"<script>",
        "DELETE FROM TODO_TITLES WHERE TDTINO IN ",
        "<foreach item='item' collection='list' open='(' separator=',' close=')'>",
          "#{item}",
        "</foreach>",
        "AND IDNO = (SELECT IDNO FROM USERS WHERE USERNAME = #{username})",
        "</script>"})
	Integer deleteTodoLists(@Param("list") List<String> ids, @Param("username") String username);
	
	
}
