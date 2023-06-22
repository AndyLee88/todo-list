package com.todo.imple.todo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class TodoTitles {
	Integer tdtino;
	String title;//    		VARCHAR2(140  CHAR),
    String descripion;//   VARCHAR2(140  CHAR),
    String status;//  VARCHAR2(10 CHAR) DEFAULT //'TODO' CHECK( STATUS IN ('TODO', 'WAIT', 'DOING', 'DONE')),
    LocalDate todoWriteAt;// DATE DEFAULT CURRENT_DATE, --생성일
    LocalDate todoDueDate;// DATE,  --마감예정일
    LocalDate todoEditAt;//  DATE,  --TODO 최종수정일
    LocalDate todoStartAt;// DATE,  --작업시작일
    LocalDate todoEndAt;//   DATE,  --작업종료일
    LocalDate orderSeq;//     DATE DEFAULT CURRENT_DATE,
    Integer importance;//    NUMBER(1),--TODO 중요도
    String todoHashTag;//   VARCHAR2(140  CHAR)
    Integer idno;
}
