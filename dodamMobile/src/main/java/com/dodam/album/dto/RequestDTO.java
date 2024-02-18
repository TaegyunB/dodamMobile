package com.dodam.album.dto;

import com.dodam.login.dto.LoginDTO;

import lombok.Data;

@Data
public class RequestDTO {

	private AlbumDTO adto;
	private LoginDTO ldto;
}
