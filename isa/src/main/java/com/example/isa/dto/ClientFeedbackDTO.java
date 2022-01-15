package com.example.isa.dto;

public class ClientFeedbackDTO {

	private String content;
	private int grade;
	private long reservation;
	
	
	public ClientFeedbackDTO(String content, int grade, long reservation) {
		super();
		this.content = content;
		this.grade = grade;
		this.reservation = reservation;
	}


	public ClientFeedbackDTO() {
		super();
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public long getReservation() {
		return reservation;
	}


	public void setReservation(long reservation) {
		this.reservation = reservation;
	}
	
	
}
