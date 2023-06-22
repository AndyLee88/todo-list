package com.todo.imple.todo.model;

import com.todo.standard.model.Modelable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class TodoDetailsDTO implements Modelable<TodoDetailsDTO> {
	Integer tddtno;//          NUMBER GENERATED ALWAYS AS IDENTITY CONSTRAINT TODO_DETAILS_TDDTNO_PK PRIMARY KEY,
    String content;//         CLOB,
    Integer tdtino;//          NUMBER,
	@Override
	public TodoDetailsDTO getModel() {
		return builder()
				.tddtno(tddtno)
				.content(content)
				.tdtino(tdtino)
				.build();
	}
}
