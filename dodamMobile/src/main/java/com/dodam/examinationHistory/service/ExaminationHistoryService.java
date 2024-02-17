package com.dodam.examinationHistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.examinationHistory.dao.ExaminationHistoryDAO;
import com.dodam.examinationHistory.dto.ExaminationHistoryDTO;

@Service
public class ExaminationHistoryService {

	@Autowired
	ExaminationHistoryDAO dao;
	
	public int insertEH(ExaminationHistoryDTO dto) {
		return dao.insertEH(dto);
	}
}
