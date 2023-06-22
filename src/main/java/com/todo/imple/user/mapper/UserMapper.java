package com.todo.imple.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.todo.imple.user.model.Users;
import com.todo.imple.user.model.UsersDTO;

@Mapper
public interface UserMapper {
	
	String selectByUsers="""
			SELECT *
            FROM USERS
			""";
	@Select(selectByUsers)
	Users selectByUsers();
	
	String selectByIdno="""
			SELECT *
            FROM USERS
            WHERE IDNO = #{idno}
			""";
	@Select(selectByIdno)
	UsersDTO selectByIdno(Integer idno);
	
	String selectByForgotPassword="""
			SELECT *
            FROM USERS
            WHERE USERNAME = #{user.username}
            AND EMAIL = #{user.email}
            AND ISBAN = 0
            AND ISDEL = 0
			""";
	@Select(selectByForgotPassword)
	UsersDTO selectByForgotPassword(@Param("user")UsersDTO usersDTO);
	
	@Select("""
			SELECT *
			FROM USERS
			WHERE USERNAME IN (
			    SELECT USERNAME
			    FROM FIND_USERS_HISTORY
			    WHERE ABS((SYSDATE - CREATE_DATE) * 24 * 60) < 10
			    ORDER BY CREATE_DATE DESC
			    FETCH FIRST 1 ROWS ONLY
			)
			AND USERNAME = #{username}
			AND ISBAN = 0
			AND ISDEL = 0
			""")
	UsersDTO selectRecentUser(String username);
	
	String selectByNewIdno="""
			SELECT *
            FROM USERS
            WHERE IDNO = #{idno}
            AND ABS((SYSDATE - USER_JOIN_DATE) * 24 * 60) < 10
			""";
	@Select(selectByNewIdno)
	UsersDTO selectByNewIdno(Integer idno);
	
	String selectByUsername="""
			SELECT *
            FROM USERS
            WHERE USERNAME = #{username}
            AND ISBAN = 0
            AND ISDEL = 0
			""";
	@Select(selectByUsername)
	UsersDTO selectByUsername(String username);
	
	String selectByFindUsername="""
			SELECT *
            FROM USERS
            WHERE USERNAME = #{username}
            AND ISBAN = 0
            AND ISDEL = 0
			""";
	@Select(selectByFindUsername)
	UsersDTO selectByFindUsername(String username);
	
	String selectSameUsername="""
			SELECT COUNT(*)
            FROM USERS
            WHERE USERNAME = #{username}
			""";
	@Select(selectSameUsername)
	Integer selectSameUsername(String username);
	
	String insertByNewUsers = """
	INSERT INTO USERS
	(USERNAME, NICKNAME, EMAIL, PASSWORD, PASSWORD2, MOBILE, ROLE)
	VALUES ( 
	 	#{user.username,  jdbcType=VARCHAR}, 
	 	#{user.nickname, 	jdbcType=VARCHAR},
	 	#{user.email, 	jdbcType=VARCHAR},
	 	#{user.password, 	jdbcType=VARCHAR},
	 	#{user.password2, 	jdbcType=VARCHAR},
	 	#{user.mobile, 	jdbcType=VARCHAR},
	 	'VISITOR'
	) 
	""";
	@Insert(insertByNewUsers)
	//@Options(useGeneratedKeys = true, keyProperty = "idno")
	int insertByNewUsers(@Param("user")UsersDTO usersDTO);

	String updateUsers = """
			UPDATE USERS
			   SET  NICKNAME = 		#{user.nickname, 	jdbcType=VARCHAR},
				 	EMAIL = 		#{user.email, 	jdbcType=VARCHAR},
				 	PASSWORD = 		#{user.password, 	jdbcType=VARCHAR},
				 	PASSWORD2 = 	#{user.password2, 	jdbcType=VARCHAR},
				 	MOBILE =		#{user.mobile, 	jdbcType=VARCHAR}
			 where USERNAME = '${user.username}'
			"""; 
	@Update(updateUsers)
	Integer updateUsers(@Param("user") UsersDTO usersDTO);
	
	String insertByUsersHistory = """
			INSERT INTO USERS_HISTORY (IDNO, USERNAME, PASSWORD, PASSWORD2, EMAIL, NICKNAME, MOBILE, PROFILE, ROLE, ISBAN, ISDEL, USER_JOIN_DATE, CREATE_DATE, USER_EDIT_DATE, USER_DELETE_DATE)
			SELECT IDNO, USERNAME, PASSWORD, PASSWORD2, EMAIL, NICKNAME, MOBILE, PROFILE, ROLE, ISBAN, ISDEL, USER_JOIN_DATE, CURRENT_DATE, CURRENT_DATE, USER_DELETE_DATE 
			FROM USERS
			WHERE USERNAME ='${user.username}'
			""";
	@Insert(insertByUsersHistory)
	int insertByUsersHistory(@Param("user")UsersDTO usersDTO);
	
	String insertByFindUsersHistory = """
			INSERT INTO FIND_USERS_HISTORY (USERNAME, EMAIL)
			VALUES ( 
				 	#{user.username,  jdbcType=VARCHAR}, 
				 	#{user.email, 	jdbcType=VARCHAR}
				 	)
			""";
	@Insert(insertByFindUsersHistory)
	Integer insertByFindUsersHistory(@Param("user")UsersDTO usersDTO);
}

