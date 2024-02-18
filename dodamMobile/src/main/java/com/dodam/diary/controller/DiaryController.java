package com.dodam.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dodam.diary.dto.DiaryDTO;
import com.dodam.diary.dto.RequestDTO;
import com.dodam.diary.service.DiaryService;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService service;
    
    // 다이어리 작성
    @PostMapping("/insert")
    public ResponseEntity<String> insertDiary(@RequestBody RequestDTO rdto) {
    	
    	DiaryDTO ddto = rdto.getDdto();
    	String userid = rdto.getLdto().getUserid();
    	
    	ddto.setUserid(userid);
    	service.insertDiary(ddto);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // 다이어리 리스트
    @GetMapping("/selectDiary/{userid}/{diaryid}")
    public ResponseEntity<List<DiaryDTO>> selectOneDiary(@PathVariable("userid") String userid, @PathVariable("diaryid") int diaryid){
    	DiaryDTO ddto = new DiaryDTO();
    	ddto.setUserid(userid);
    	ddto.setDiaryid(diaryid);
    	
    	List<DiaryDTO> selectOneDiary = service.selectOneDiary(ddto);
    	return new ResponseEntity<>(selectOneDiary, HttpStatus.OK);
    }
    
    // 다이어리 전체 리스트
    @GetMapping("/diaryList/{userid}")
    public ResponseEntity<List<DiaryDTO>> todoListByUserid(@PathVariable("userid") String userid){
    	List<DiaryDTO> diaryListByUserid = service.diaryListByUserid(userid);
    	return new ResponseEntity<>(diaryListByUserid, HttpStatus.OK);
    }
    
    // 다이어리 수정
    @PutMapping("/updateDiary/{userid}/{diaryid}")
    public ResponseEntity<String> updateDiary(@RequestBody RequestDTO rdto, @PathVariable("userid") String userid, @PathVariable("diaryid") int diaryid){
    	DiaryDTO ddto = rdto.getDdto();
    	ddto.setUserid(userid);
    	ddto.setDiaryid(diaryid);
    	
    	service.updateDiary(ddto);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // 다이어리 삭제
    @DeleteMapping("/deleteDiary/{userid}/{diaryid}")
    public ResponseEntity<String> deleteDiary(@PathVariable("userid") String userid, @PathVariable("diaryid") int diaryid){
    	DiaryDTO ddto = new DiaryDTO();
    	ddto.setUserid(userid);
    	ddto.setDiaryid(diaryid);
    	
    	service.deleteDiary(ddto);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
