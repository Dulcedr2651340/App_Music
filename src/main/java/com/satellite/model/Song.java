package com.satellite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="song")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer song_id;
	
	private	String name;
	private String artist;
	private	String album;
	private String duration;
	private	String image_url;
	private String video_url;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isFavorite;

	
	@ManyToOne
	@JoinColumn(name = "id_gender", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign Key(id_gender) references gender(id_gender)"))
	private Gender gender;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(Integer song_id, String name, String artist, String album, String duration, String image_url,
			String video_url, Boolean isFavorite, Gender gender) {
		super();
		this.song_id = song_id;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.duration = duration;
		this.image_url = image_url;
		this.video_url = video_url;
		this.isFavorite = isFavorite;
		this.gender = gender;
	}

	public Integer getSong_id() {
		return song_id;
	}

	public void setSong_id(Integer song_id) {
		this.song_id = song_id;
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	

}
