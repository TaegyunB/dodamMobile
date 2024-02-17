package com.dodam.examinationHistory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.examinationHistory.dto.ExaminationHistoryDTO;

@Mapper
public interface ExaminationHistoryDAO {
	
	// 진찰 내역 추가
	public int insertEH(ExaminationHistoryDTO dto);

	// 진찰 내역 리스트
	public List<ExaminationHistoryDTO> selectOneEH(ExaminationHistoryDTO dto);
	
	// 진찰 내역 전체 리스트
	public List<ExaminationHistoryDTO> selectAllEH(String connection_id);
	
	// 진찰 내역 수정
	public int updateEH(ExaminationHistoryDTO dto);
	
	// 진찰 내역 삭제
	public int deleteEH(ExaminationHistoryDTO dto);
	
}
