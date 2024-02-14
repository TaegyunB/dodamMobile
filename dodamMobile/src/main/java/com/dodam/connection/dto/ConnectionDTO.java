package com.dodam.connection.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ConnectionDTO {
	private String user1_id;
	private String user2_id;
	
	String code = UUID.randomUUID().toString();
	private String connection_id = code.substring(0,8);
	
}
