package com.dodam.baby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.baby.dao.BabyDAO;
import com.dodam.baby.dto.BabyDTO;

@Service
public class BabyService {

	@Autowired
	BabyDAO dao;
	
	// 아기 추가
	public int insertBabyInfo(BabyDTO dto) {
		return dao.insertBabyInfo(dto);
	}
	
	// 아기 리스트
	public List<BabyDTO> selectOneBaby(BabyDTO dto){
		return dao.selectOneBaby(dto);
	}
	
	// 아기 전체 리스트
	public List<BabyDTO> babyList(String connection_id){
		return dao.babyList(connection_id);
	}
	
	// 아기 정보 수정
	public int updateBabyInfo(BabyDTO dto) {
		return dao.updateBabyInfo(dto);
	}
	
	// 아기 삭제
	public int deleteBaby(BabyDTO dto) {
		return dao.deleteBaby(dto);
	}
	
}
