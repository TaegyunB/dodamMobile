package com.dodam.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.login.dao.LoginDAO;
import com.dodam.login.dto.LoginDTO;

@Service
public class LoginService {

	@Autowired
	LoginDAO dao;
	
	// 회원가입
	public int insertUser(LoginDTO dto) {
		return dao.insertUser(dto);
	}
	
	// 로그인
	public LoginDTO login(LoginDTO dto) {
		return dao.login(dto);
	}
	
	// 아이디 중복 체크
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}
	
	// 회원정보 수정
	public int updateUser(LoginDTO dto) {
		return dao.updateUser(dto);
	}
	
	// 회원 탈퇴
	public int deleteUser(String userid) {
		return dao.deleteUser(userid);
	}
		
	// 회원 정보
	public LoginDTO selectUser(String userid) {
		return dao.selectUser(userid);
	}
	
}
