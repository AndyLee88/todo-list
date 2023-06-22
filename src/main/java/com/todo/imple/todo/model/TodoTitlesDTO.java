package com.todo.imple.todo.model;

import java.time.LocalDateTime;

import com.todo.standard.model.Modelable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class TodoTitlesDTO implements Modelable<TodoTitlesDTO> {
	Integer tdtino;
	String title;//    		VARCHAR2(140  CHAR),
    String description;//   VARCHAR2(140  CHAR),
    String status;//  VARCHAR2(10 CHAR) DEFAULT 'TODO' CHECK( STATUS IN ('TODO', 'WAIT', 'DOING', 'DONE')),
    LocalDateTime todoWriteAt;// DATE DEFAULT CURRENT_DATE, --생성일
    String todoDueDateStr;//--마감예정일 String
    String todoEditAtStr;// 최종수정일 String
    String todoStartAtStr;//--작업시작일 String
    String todoEndAtStr;//--작업종료일 String
    LocalDateTime todoDueDate;// DATE,  --마감예정일
    LocalDateTime todoEditAt;//  DATE,  --TODO 최종수정일
    LocalDateTime todoStartAt;// DATE,  --작업시작일
    LocalDateTime todoEndAt;//   DATE,  --작업종료일
    String orderSeq;//     DATE DEFAULT CURRENT_DATE,
    String importance;//    NUMBER(1),--TODO 중요도
    String todoHashTag;//   VARCHAR2(140  CHAR)
    Integer idno;
    
    @Override
    public TodoTitlesDTO getModel() {
    	return builder()
    			.title(title)
    			.description(description)
    			.status(status)
    			.todoEditAt(todoEditAt)
    			.todoStartAt(todoStartAt)
    			.todoEditAt(todoEditAt)
    			.importance(importance)
    			.idno(idno)
    			.build();
    			
    }
}
