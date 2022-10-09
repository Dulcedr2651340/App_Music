package com.satellite.mapper;

import com.satellite.model.Gender;

public class GenderMapper {

	private Integer idGender;
	private String  type;
	private	String description;
	private Integer color_code;
	
	public GenderMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public GenderMapper(Gender g) {
		this(g.getId_gender(), g.getType(),g.getDescription(), g.getColor_code());
	}

	public GenderMapper(Integer idgender, String type, String description, Integer color_code) {
		super();
		this.idGender = idgender;
		this.type = type;
		this.description = description;
		this.color_code = color_code;
	}

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getColor_code() {
		return color_code;
	}

	public void setColor_code(Integer color_code) {
		this.color_code = color_code;
	}
	
	
	
	
}
