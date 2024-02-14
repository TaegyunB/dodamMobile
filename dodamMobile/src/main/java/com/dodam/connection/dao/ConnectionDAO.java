package com.dodam.connection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.connection.dto.ConnectionDTO;

@Mapper
public interface ConnectionDAO {
	
	public int connectUser(ConnectionDTO dto);
	public String isUserExist(String userid);
	public List<String> hasConnection();
	
}
