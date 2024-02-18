package com.dodam.album.dto;

import lombok.Data;

@Data
public class AlbumDTO {

	private String connection_id;
    private String userid;
    private int albumid;
    private String title;
    private String creationDate;
    //private String photo;  // 로컬 경로 저장용
}
