package com.todo.imple.todo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoJson {
	private String title;
    private String start;
    private String end;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(LocalDateTime start) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.start = start.format(formatter);
    }

    public void setEnd(LocalDateTime end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.end = end.format(formatter);
    }

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}
    
    
}
