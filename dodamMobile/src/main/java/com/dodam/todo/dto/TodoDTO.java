package com.dodam.todo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {

	private String connection_id;
	private int todoid;
	private String title;
	private String content;
	private Date closingDate;
}
