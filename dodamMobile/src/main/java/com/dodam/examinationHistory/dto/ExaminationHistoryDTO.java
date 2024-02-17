package com.dodam.examinationHistory.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ExaminationHistoryDTO {

	private String connection_id;
	private int examinationid;
	private Date examinationDate;
	private int pregnacyWeek;
	private double weight;
	private double bloodPressure;
	private String urinalysis;
	private double embryocadia;
	private String requirement;
	private Date nextVisitDate;
}
