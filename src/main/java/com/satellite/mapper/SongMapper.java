package com.satellite.mapper;

import com.satellite.model.Song;

public class SongMapper {

	private Integer songId;
	private Integer idGender;
	private	String name;
	private String artist;
	private	String album;
	private String duration;
	private	String imageUrl;
	private String videoUrl;
	private Boolean isFavorite;
	
	
	public SongMapper(Song s) {
		this(s.getSong_id(), s.getGender().getId_gender(), s.getName(), s.getArtist(), s.getAlbum(), s.getDuration(), s.getImage_url(), s.getVideo_url(), s.getIsFavorite());
	}


	public SongMapper(Integer songId, Integer idGender, String name, String artist, String album, String duration,
			String imageUrl, String videoUrl, Boolean isFavorite) {
		super();
		this.songId = songId;
		this.idGender = idGender;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.duration = duration;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.isFavorite = isFavorite;
	}


	public Integer getSongId() {
		return songId;
	}


	public void setSongId(Integer songId) {
		this.songId = songId;
	}


	public Integer getIdGender() {
		return idGender;
	}


	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getVideoUrl() {
		return videoUrl;
	}


	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}


	public Boolean getIsFavorite() {
		return isFavorite;
	}


	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}


	
	
	
}
