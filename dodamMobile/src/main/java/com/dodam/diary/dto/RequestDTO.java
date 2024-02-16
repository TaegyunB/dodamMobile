package com.dodam.diary.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {

	private LoginDTO ldto;
	private DiaryDTO ddto;
}
