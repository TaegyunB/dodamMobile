package com.dodam.examinationHistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.examinationHistory.dao.ExaminationHistoryDAO;
import com.dodam.examinationHistory.dto.ExaminationHistoryDTO;

@Service
public class ExaminationHistoryService {

	@Autowired
	ExaminationHistoryDAO dao;
	
	// 진찰 내역 추가
	public int insertEH(ExaminationHistoryDTO dto) {
		return dao.insertEH(dto);
	}
	
	// 진찰 내역 리스트
	public List<ExaminationHistoryDTO> selectOneEH(ExaminationHistoryDTO dto) {
		return dao.selectOneEH(dto);
	}
	
	// 진찰 내역 전체 리스트
	public List<ExaminationHistoryDTO> selectAllEH(String connection_id) {
		return dao.selectAllEH(connection_id);
	}
	
	// 진찰 내역 수정
	public int updateEH(ExaminationHistoryDTO dto) {
		return dao.updateEH(dto);
	}
	
	// 진찰 내역 삭제
	public int deleteEH(ExaminationHistoryDTO dto) {
		return dao.deleteEH(dto);
	}
}
