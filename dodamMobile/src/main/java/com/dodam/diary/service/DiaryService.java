package com.dodam.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.diary.dao.DiaryDAO;
import com.dodam.diary.dto.DiaryDTO;

@Service
public class DiaryService {

    @Autowired
    DiaryDAO dao;
    
    // 다이어리 작성
    public int insertDiary(DiaryDTO dto) {
    	return dao.insertDiary(dto);
    }
    
    // 다이어리 리스트
    public List<DiaryDTO> selectOneDiary(DiaryDTO dto) {
    	return dao.selectOneDiary(dto);
    }
    
    // 다이어리 전체 리스트
    public List<DiaryDTO> diaryListByUserid(String userid){
    	return dao.diaryListByUserid(userid);
    }
    
    // 다이어리 수정
    public int updateDiary(DiaryDTO dto) {
    	return dao.updateDiary(dto);
    }
    
    // 다이어리 삭제
    public int deleteDiary(DiaryDTO dto) {
    	return dao.deleteDiary(dto);
    }
    
    
    
    

//    public int postdiary(DiaryDTO dto) { return dao.postdiary(dto); }
//    public int deletediary(DiaryDTO dto) {
//        // 삭제하시겠습니까?? 에 해당하는 무언가가 들어가야 할 것 같은데..
//        return dao.deletediary(dto);
//    }
//
//    //public int updatediary(DiaryDTO dto) { return dao.updatediary(dto); }
//
//    public void updateDiaryPartially(Map<String, Object> updates, String diaryid, String userid) {
//        DiaryDTO dto = new DiaryDTO();
//        dto.setDiaryid(diaryid);
//        dto.setUserid(userid);
//        DiaryDTO existingDiary = dao.getdiary(dto);
//        if (existingDiary == null) {
//            throw new IllegalArgumentException("Diary not found");
//        }
//
//        if (updates.containsKey("title")) {
//            existingDiary.setTitle((String) updates.get("title"));
//        }
//        if (updates.containsKey("content")) {
//            existingDiary.setContent((String) updates.get("content"));
//        }
//        if (updates.containsKey("photo")) {
//            existingDiary.setPhoto((String) updates.get("photo"));
//        }
//        // 여기에 다른 필드에 대한 업데이트 로직 추가...
//
//        dao.partialUpdate(existingDiary);
//    }
//
//    public DiaryDTO getdiary(DiaryDTO dto) { return dao.getdiary(dto); }
//
//    public List<DiaryDTO> getAlldiary(DiaryDTO dto) { return dao.getAlldiary(dto); }
}