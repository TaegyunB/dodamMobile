package com.dodam.baby.controller;

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

import com.dodam.baby.dto.BabyDTO;
import com.dodam.baby.dto.RequestDTO;
import com.dodam.baby.service.BabyService;

@RestController
@RequestMapping("/baby")
public class BabyController {

	@Autowired
	BabyService service;

	// 아기 추가
	@PostMapping("/insertBabyInfo")
	public ResponseEntity<String> insertBabyInfo(@RequestBody RequestDTO rdto){
		BabyDTO bdto = rdto.getBdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		bdto.setConnection_id(connection_id);
		service.insertBabyInfo(bdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 아기 1명
	@GetMapping("/selectOneBaby/{babyid}")
	public ResponseEntity<List<BabyDTO>> selectOneBaby(@PathVariable("babyid") int babyid){
		List<BabyDTO> selectOneBaby = service.selectOneBaby(babyid);
		return new ResponseEntity<>(selectOneBaby, HttpStatus.OK);
	}
	
	// 아기 리스트
	@GetMapping("/babyList/{connection_id}")
	public ResponseEntity<List<BabyDTO>> babyList(@PathVariable("connection_id") String connection_id){
		List<BabyDTO> babyList = service.babyList(connection_id);
		return new ResponseEntity<>(babyList, HttpStatus.OK);
	}
	
	// 아기 정보 수정
	@PutMapping("/updateBabyInfo")
	public ResponseEntity<String> update(@RequestBody RequestDTO rdto){
		BabyDTO bdto = rdto.getBdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		bdto.setConnection_id(connection_id);
		service.updateBabyInfo(bdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 아기 삭제
	@DeleteMapping("/deleteBaby/{babyid}")
	public ResponseEntity<String> deleteBaby(@PathVariable("babyid") int babyid){
		service.deleteBaby(babyid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
