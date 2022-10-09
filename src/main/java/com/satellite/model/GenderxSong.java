package com.satellite.model;

import java.util.List;

import com.satellite.mapper.SongMapper;

public class GenderxSong {
	
	private Gender gender;
	private List<SongMapper> songsList;
	
	
	public GenderxSong() {
		// TODO Auto-generated constructor stub
	}


	public GenderxSong(Gender gender, List<SongMapper> songsList) {
		super();
		this.gender = gender;
		this.songsList = songsList;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public List<SongMapper> getSongsList() {
		return songsList;
	}


	public void setSongsList(List<SongMapper> songsList) {
		this.songsList = songsList;
	}


}
