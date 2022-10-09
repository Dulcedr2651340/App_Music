package com.satellite.model;

import java.util.List;

public class ResponseData<t> {
	
	private String type_data;
	private Object data;
	
	public ResponseData() {
		// TODO Auto-generated constructor stub
	}

	
	public ResponseData(String type_data, Object data) {
		super();
		this.type_data = type_data;
		this.data = data;
	}


	public String getType_data() {
		return type_data;
	}

	public void setType_data(String type_data) {
		this.type_data = type_data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	

}
