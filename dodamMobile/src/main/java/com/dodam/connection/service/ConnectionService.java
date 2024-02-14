package com.dodam.connection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.connection.dao.ConnectionDAO;
import com.dodam.connection.dto.ConnectionDTO;

@Service
public class ConnectionService {

	@Autowired
	ConnectionDAO dao;
	
	public int connectUser(ConnectionDTO dto) {
		return dao.connectUser(dto);
	}
	
	public boolean isUserExist(String userid) {
		String user = dao.isUserExist(userid);
		return user != null; // 사용자 정보가 존재하면 true, 존재하지 않으면 false
	}
	
	// 작동 x
	public boolean checkConnectionId(String connection_id) {
		List<String> connectionIds = dao.hasConnection();
		return connectionIds.contains(connection_id);
	}
}
