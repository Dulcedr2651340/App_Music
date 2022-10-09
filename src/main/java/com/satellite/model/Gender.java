package com.satellite.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="gender")
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_gender;
	private String  type;
	private	String description;
	private Integer color_code;
	

	@OneToMany(mappedBy = "gender")
	private Collection<Song> itemsSong = new ArrayList<>();
	
	
	public Gender(){
		// TODO Auto-generated constructor stub
	}


	public Gender(Integer id_gender, String type, String description, Integer color_code) {
		super();
		this.id_gender = id_gender;
		this.type = type;
		this.description = description;
		this.color_code = color_code;
	
	}


	public Integer getId_gender() {
		return id_gender;
	}


	public void setId_gender(Integer id_gender) {
		this.id_gender = id_gender;
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
