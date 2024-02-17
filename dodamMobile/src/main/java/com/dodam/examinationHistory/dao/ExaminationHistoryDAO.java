package com.dodam.examinationHistory.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.examinationHistory.dto.ExaminationHistoryDTO;

@Mapper
public interface ExaminationHistoryDAO {
	
	public int insertEH(ExaminationHistoryDTO dto);

}
