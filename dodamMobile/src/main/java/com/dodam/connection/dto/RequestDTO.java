package com.dodam.connection.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {
	private ConnectionDTO cdto;
	private LoginDTO ldto;
}
