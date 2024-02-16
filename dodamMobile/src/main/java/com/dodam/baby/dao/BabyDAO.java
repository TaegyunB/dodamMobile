package com.dodam.baby.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.baby.dto.BabyDTO;

@Mapper
public interface BabyDAO {
	
	// 아기 추가
	public int insertBabyInfo(BabyDTO dto);
	
	// 아기 리스트
	public List<BabyDTO> babyList(String connection_id);
	
	// 아기 정보 수정
	public int updateBabyInfo(BabyDTO dto);
	
	// 아기 삭제
	public int deleteBaby(int babyid);
	
	
}
