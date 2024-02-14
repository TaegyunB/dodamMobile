package com.dodam.login.controller;

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

import com.dodam.login.dto.LoginDTO;
import com.dodam.login.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService service;

	
	// 회원가입
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody LoginDTO dto){
		int idCheckResult = service.idCheck(dto.getUserid());
		if(idCheckResult == 1) {
			return new ResponseEntity<>("This ID already exists.", HttpStatus.BAD_REQUEST);
		} else {
			service.insertUser(dto);
			return new ResponseEntity<>("Registration Successful.", HttpStatus.CREATED);
		}
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> loginUser(@RequestBody LoginDTO dto){
		LoginDTO loginUser = service.login(dto);
		if(loginUser == null) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(loginUser, HttpStatus.OK);
		}
	}

	
	// 회원정보 가져오기
	@GetMapping("/userInfo/{userid}")
	public ResponseEntity<LoginDTO> getUserInfo(@PathVariable("userid") String userid){
		 LoginDTO user = service.selectUser(userid);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
	}

	// 회원정보 수정
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody LoginDTO dto){
		service.updateUser(dto);
		return new ResponseEntity<>("User info updated.", HttpStatus.OK);
	}
	
	// 회원 탈퇴
	@DeleteMapping("/delete/{userid}") // 작동 x
		public ResponseEntity<String> deleteUser(@PathVariable("userid") String userid, @RequestBody LoginDTO dto){
		int deleteResult = service.deleteUser(dto.getPassword(), dto);
		if(deleteResult == 0) {
			return new ResponseEntity<>("Delete Failed.", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("User deletion successful.", HttpStatus.OK);
		}
		
	}
	
	// 로그아웃
	
	
}
