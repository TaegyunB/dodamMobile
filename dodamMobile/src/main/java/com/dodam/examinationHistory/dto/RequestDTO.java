package com.dodam.examinationHistory.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {

	private ExaminationHistoryDTO ehdto;
	private LoginDTO ldto;
}
