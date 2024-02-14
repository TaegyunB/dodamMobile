package com.dodam.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.login.dto.LoginDTO;

@Mapper
public interface LoginDAO {

	// 회원가입
	public int insertUser(LoginDTO dto);
	
	// 로그인
	public LoginDTO login(LoginDTO dto);
	
	// 아이디 중복 체크
	public int idCheck(String userid);
	
	// 회원정보 수정
	public int updateUser(LoginDTO dto);
	
	// 회원 탈퇴
	public int deleteUser(String userid);
	
	// 회원 정보
	public LoginDTO selectUser(String userid);
	
}
