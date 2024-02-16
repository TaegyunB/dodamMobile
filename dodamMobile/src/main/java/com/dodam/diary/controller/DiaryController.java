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
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/diaryList/{userid}")
    public ResponseEntity<List<DiaryDTO>> todoListByUserid(@PathVariable("userid") String userid){
    	List<DiaryDTO> diaryListByUserid = service.diaryListByUserid(userid);
    	return new ResponseEntity<>(diaryListByUserid, HttpStatus.OK);
    }
    
    // 다이어리 수정
    @PutMapping("/updateDiary")
    public ResponseEntity<String> updateDiary(@RequestBody RequestDTO rdto){
    	DiaryDTO ddto = rdto.getDdto();
    	String userid = rdto.getLdto().getUserid();
    	
    	ddto.setUserid(userid);
    	service.updateDiary(ddto);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    // 다이어리 삭제
    @DeleteMapping("/deleteDiary/{diaryid}")
    public ResponseEntity<String> deleteDiary(@PathVariable("diaryid") int diaryid){
    	service.deleteDiary(diaryid);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
