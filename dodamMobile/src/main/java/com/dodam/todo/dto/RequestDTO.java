package com.dodam.todo.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {

	private TodoDTO tdto;
	private LoginDTO ldto;
}
