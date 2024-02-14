package com.dodam.baby.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {
	private LoginDTO ldto;
	private BabyDTO bdto;
}
