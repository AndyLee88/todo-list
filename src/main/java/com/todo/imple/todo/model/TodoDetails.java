package com.todo.imple.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class TodoDetails {
	Integer tddtno;//          NUMBER GENERATED ALWAYS AS IDENTITY CONSTRAINT TODO_DETAILS_TDDTNO_PK PRIMARY KEY,
    String content;//         CLOB,
    Integer tdtino;//          NUMBER,
}
