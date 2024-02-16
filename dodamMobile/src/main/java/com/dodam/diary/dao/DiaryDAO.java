package com.dodam.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.diary.dto.DiaryDTO;

@Mapper
public interface DiaryDAO {

	// 다이어리 작성
	public int insertDiary(DiaryDTO dto);
	
	// 다이어리 1개
	public List<DiaryDTO> selectOneDiary(int diaryid);
	
	// 다이어리 리스트
	public List<DiaryDTO> diaryListByUserid(String userid);
	
	// 다이어리 수정
	public int updateDiary(DiaryDTO dto);
	
	// 다이어리 삭제
	public int deleteDiary(int diaryid);

}
