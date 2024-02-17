package com.dodam.connection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.connection.dto.ConnectionDTO;

@Mapper
public interface ConnectionDAO {
	
	// 유저 연결
	public int connectUser(ConnectionDTO dto);
	
	// 유저 존재 여부
	public String isUserExist(String userid);
	
	// 유저 연결 여부
	public List<String> hasConnection();
	
	// 연결된 유저 삭제
	public int deleteConnection(ConnectionDTO dto);
}
