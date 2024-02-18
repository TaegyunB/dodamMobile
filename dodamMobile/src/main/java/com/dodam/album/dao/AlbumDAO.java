package com.dodam.album.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.album.dto.AlbumDTO;

@Mapper
public interface AlbumDAO {

	// 앨범 작성
    public int postAlbum(AlbumDTO dto);
    
    // 앨범 불러오기
    public List<AlbumDTO> getAlbum(AlbumDTO dto);
    
    // 전체 앨범 불러오기
    public List<AlbumDTO> getAllAlbum(String connection_id);
    
    // 앨범 수정 
    public int updateAlbum(AlbumDTO dto);
    
    // 앨범 삭제
    public int deleteAlbum(AlbumDTO dto);
   
    
    


}
