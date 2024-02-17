package com.dodam.connection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodam.connection.dto.ConnectionDTO;
import com.dodam.connection.dto.RequestDTO;
import com.dodam.connection.service.ConnectionService;
import com.dodam.login.dto.LoginDTO;

@RestController
@RequestMapping("/api")
public class ConnectionController {

	@Autowired
	ConnectionService service;
	
	// 유저 연결
	@PostMapping("/connectionform")
	public ResponseEntity<?> connectUser(@RequestBody RequestDTO rdto){
		ConnectionDTO cdto = rdto.getCdto();
		LoginDTO ldto = rdto.getLdto();
		
		if (service.isUserExist(cdto.getUser2_id())) {
			if(service.checkConnectionId(ldto.getConnection_id())) { // 작동 x
				return new ResponseEntity<>("이미 연결되어있습니다.", HttpStatus.ALREADY_REPORTED);
			} else {
			service.connectUser(cdto);
			return new ResponseEntity<>(HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>("해당 유저가 없음", HttpStatus.NOT_FOUND);
					
		}
	}
	
//	// 연결된 유저 삭제
//	@DeleteMapping("/deleteConnection/{userid}/{connection_id}")
//	
	
}
