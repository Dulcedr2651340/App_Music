package com.satellite.model;

import java.util.Date;

public class ResponseMessage {
	
	private String message;
	private Date date;
	private Boolean state;
	
	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}

	public ResponseMessage(String message, Date date, Boolean state) {
		super();
		this.message = message;
		this.date = date;
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	
		

}
