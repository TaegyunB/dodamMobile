package com.dodam.examinationHistory.controller;

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

import com.dodam.examinationHistory.dto.ExaminationHistoryDTO;
import com.dodam.examinationHistory.dto.RequestDTO;
import com.dodam.examinationHistory.service.ExaminationHistoryService;

@RestController
@RequestMapping("/examinationHistory")
public class ExaminationHistoryController {
	
	@Autowired
	ExaminationHistoryService service;

	// 진찰 내역 추가
	@PostMapping("/insert")
	public ResponseEntity<String> insertEH(@RequestBody RequestDTO rdto){
		ExaminationHistoryDTO ehdto = rdto.getEhdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		ehdto.setConnection_id(connection_id);
		service.insertEH(ehdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 진찰 내역 리스트
	@GetMapping("/selectEH/{connection_id}/{examinationid}")
	public ResponseEntity<List<ExaminationHistoryDTO>> selectOneEH(@PathVariable("connection_id") String connection_id, @PathVariable("examinationid") int examinationid){
		ExaminationHistoryDTO ehdto = new ExaminationHistoryDTO();
		ehdto.setConnection_id(connection_id);
		ehdto.setExaminationid(examinationid);
		
		List<ExaminationHistoryDTO> selectOneEH = service.selectOneEH(ehdto);
		return new ResponseEntity<>(selectOneEH, HttpStatus.OK);
	}
	
	// 진찰 내역 전체 리스트
	@GetMapping("/selectAllEH/{connection_id}")
	public ResponseEntity<List<ExaminationHistoryDTO>> selectAllEH(@PathVariable("connection_id") String connection_id){
		List<ExaminationHistoryDTO> selectAllEH = service.selectAllEH(connection_id);
		return new ResponseEntity<>(selectAllEH, HttpStatus.OK);
	}
	
	// 진찰 내역 수정
	@PutMapping("/updateEH/{connection_id}/{examinationid}")
	public ResponseEntity<String> updateEH(@RequestBody RequestDTO rdto, @PathVariable("connection_id") String connection_id, @PathVariable("examinationid") int examinationid) {
		ExaminationHistoryDTO ehdto = rdto.getEhdto();
		ehdto.setConnection_id(connection_id);
		ehdto.setExaminationid(examinationid);
		
		service.updateEH(ehdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 진찰 내역 삭제
	@DeleteMapping("/deleteEH/{connection_id}/{examinationid}")
	public ResponseEntity<String> deleteEH(@PathVariable("connection_id") String connection_id, @PathVariable("examinationid") int examinationid){
		ExaminationHistoryDTO ehdto = new ExaminationHistoryDTO();
		ehdto.setConnection_id(connection_id);
		ehdto.setExaminationid(examinationid);
		
		service.deleteEH(ehdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}









