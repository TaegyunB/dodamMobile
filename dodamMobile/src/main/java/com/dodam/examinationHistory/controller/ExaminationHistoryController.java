package com.dodam.examinationHistory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/insert")
	public ResponseEntity<String> insertEH(@RequestBody RequestDTO rdto){
		ExaminationHistoryDTO ehdto = rdto.getEhdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		ehdto.setConnection_id(connection_id);
		service.insertEH(ehdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
