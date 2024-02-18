package com.dodam.album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodam.album.dto.AlbumDTO;
import com.dodam.album.dto.RequestDTO;
import com.dodam.album.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService service;

    // 앨범 작성
    @PostMapping("/postAlbum")
    public ResponseEntity<String> writeAlbum(@RequestBody RequestDTO rdto) {
    	
    	AlbumDTO adto = rdto.getAdto();
    	String connection_id = rdto.getLdto().getConnection_id();
    	
    	adto.setConnection_id(connection_id);
        service.postAlbum(adto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 앨범 리스트
    @GetMapping("/selectAlbum/{connection_id}/{albumid}")
    public ResponseEntity<List<AlbumDTO>> viewAlbum(@PathVariable("connection_id") String connection_id, @PathVariable("albumid") int albumid) {
        AlbumDTO adto = new AlbumDTO();
        adto.setConnection_id(connection_id);
        adto.setAlbumid(albumid);
        
        List<AlbumDTO> viewAlbum = service.getAlbum(adto);
        return new ResponseEntity<>(viewAlbum, HttpStatus.OK);
    }

    // 앨범 전체 리스트
    @GetMapping("/selectAllAlbum/{connection_id}")
    public ResponseEntity<List<AlbumDTO>> viewAllAlbum(@PathVariable("connection_id") String connection_id) {
        List<AlbumDTO> viewAllAlbum = service.getAllalbum(connection_id);
        return new ResponseEntity<>(viewAllAlbum, HttpStatus.OK);
    }

    // 수정
    @PutMapping("/updateAlbum/{connection_id}/{albumid}")
    public ResponseEntity<List<AlbumDTO>> updateAlbum(@RequestBody RequestDTO rdto, @PathVariable("connection_id") String connection_id, @PathVariable("albumid") int albumid) {
        AlbumDTO adto = rdto.getAdto();
    	adto.setConnection_id(connection_id);
        adto.setAlbumid(albumid);
        
        service.updateAlbum(adto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/deleteAlbum/{connection_id}/{albumid}")
    public ResponseEntity<String> deleteAlbum(@PathVariable("connection_id") String connection_id, @PathVariable("albumid") int albumid) {
        AlbumDTO adto = new AlbumDTO();
        adto.setConnection_id(connection_id);
        adto.setAlbumid(albumid);
        
        service.deleteAlbum(adto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
