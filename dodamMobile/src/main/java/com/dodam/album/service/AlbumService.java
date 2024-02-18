package com.dodam.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.album.dao.AlbumDAO;
import com.dodam.album.dto.AlbumDTO;

@Service
public class AlbumService {

    @Autowired
    AlbumDAO dao;

    // 앨범 작성
    public int postAlbum(AlbumDTO dto) { 
    	return dao.postAlbum(dto); 
    }
    
    // 앨범 불러오기
    public List<AlbumDTO> getAlbum(AlbumDTO dto) { 
    	return dao.getAlbum(dto); 
    }
    
    // 전체 앨범 불러오기
    public List<AlbumDTO> getAllalbum (String connection_id) { 
    	return dao.getAllAlbum(connection_id); 
    }
    
    // 앨범 수정
    public int updateAlbum(AlbumDTO dto) {
    	return dao.updateAlbum(dto);
    }
    
    // 앨범 삭제
    public int deleteAlbum(AlbumDTO dto) {
    	return dao.deleteAlbum(dto);
    }

    
}
