package com.dodam.baby.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.baby.dto.BabyDTO;

@Mapper
public interface BabyDAO {
	// 아기 정보 입력
	public int insertBabyInfo(BabyDTO dto);
	
	// 아기 리스트 가져오기
	List<BabyDTO> babyList(String connection_id);
	
	// 아기 정보 수정
	public int updateBabyInfo(BabyDTO dto);
}
