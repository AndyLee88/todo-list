package com.todo.imple.user.model;

import java.time.LocalDate;

import com.todo.standard.model.Modelable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class UsersDTO implements Modelable<UsersDTO>{
				Integer idno; //NUMBER GENERATED ALWAYS AS IDENTITY CONSTRAINT USERS_IDNO_PK PRIMARY KEY,
    @NotNull	String username; //   VARCHAR2(20  char),
    @NotNull	String nickname; //         VARCHAR2(16  char),
	@NotNull	String email; //      VARCHAR2(40  char),
	@NotNull	String password; //   VARCHAR2(100 char),
	String password2; //   VARCHAR2(30 char),
	String mobile; //     VARCHAR2(15  char),
	String mob1; //     VARCHAR2(4  char),
	String mob2; //     VARCHAR2(4  char),
	String mob3; //     VARCHAR2(4  char),
	String profile; //    VARCHAR2(40  char),
	String role; //       VARCHAR2(20  char),
    Integer isban; //      NUMBER(1) DEFAULT 0 CHECK( ISBAN IN (0, 1)),
    Integer isdel; //      NUMBER(1) DEFAULT 0 CHECK( ISBAN IN (0, 1)),
    LocalDate userJoinDate; // DATE DEFAULT CURRENT_DATE,
    LocalDate userEditDate; // DATE,
    LocalDate userDeleteDate; // DATE
	@Override
	public UsersDTO getModel() {
		return builder()
				.idno(idno)
				.username(username)
				.nickname(nickname)
				.email(email)
				.password(password)
				.password2(password2)
				.mob1(mob1)
				.mob2(mob2)
				.mob3(mob3)
				.mobile(mobile)
				.profile(profile)
				.role(role)
				.isban(isban)
				.isdel(isdel)
				.userJoinDate(userJoinDate)
				.userEditDate(userEditDate)
				.userDeleteDate(userDeleteDate)
				.build();
	}
}