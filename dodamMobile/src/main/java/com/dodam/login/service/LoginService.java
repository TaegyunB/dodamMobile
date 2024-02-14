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
	public int deleteUser(String formpw, LoginDTO dto) {
		String pw = dto.getPassword();
		if (pw.equals(formpw)) {
			return dao.deleteUser(dto.getUserid());
		}
		else {
			return 0; // 일치하지 않으면 0을 반환 => 삭제 작업이 실패했음을 의미함
		}
	}
		
	// 회원 정보
	public LoginDTO selectUser(String userid) {
		return dao.selectUser(userid);
	}
	
}
