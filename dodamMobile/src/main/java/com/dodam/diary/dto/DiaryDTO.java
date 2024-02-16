package com.dodam.diary.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DiaryDTO {

    private String userid;
    private int diaryid;
    private String title;
    private String content;
    private Date writtenDate;
    // private MultipartFile image;
}

