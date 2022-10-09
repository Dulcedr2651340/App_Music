package com.satellite.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satellite.mapper.SongMapper;
import com.satellite.model.Gender;
import com.satellite.model.ResponseMessage;
import com.satellite.model.Song;
import com.satellite.repository.IGender;
import com.satellite.repository.ISong;



@Service
public class SongServices {

	@Autowired
	private ISong repository;
	
	@Autowired
	private IGender iGender;
	
	public List<Song> list(){
		return (List<Song>) repository.findAll();
	}

	
	public Song findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Song insert(SongMapper song) {
		
	
		try {

			Gender genderDB = iGender.findById(song.getIdGender()).orElse(null);
		
			
			if(genderDB != null) {
				Song obj = new Song(song.getSongId(), song.getName(), song.getArtist(), song.getAlbum(), song.getDuration(), song.getImageUrl(), song.getVideoUrl(), song.getIsFavorite(), genderDB);
				return repository.save(obj);
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public Song update(SongMapper song) {
		Gender genderDB = iGender.findById(song.getIdGender()).orElse(null);
		Song songDB = repository.findById(song.getSongId()).orElse(null);
		if(song != null) {
			songDB.setName(song.getName());
			songDB.setArtist(song.getArtist());
			songDB.setAlbum(song.getAlbum());
			songDB.setDuration(song.getDuration());
			songDB.setImage_url(song.getImageUrl());
			songDB.setVideo_url(song.getVideoUrl());
			songDB.setGender(genderDB);
			songDB.setIsFavorite(song.getIsFavorite());
			return repository.save(songDB);
		}
		return null;		
	}
	
	
	public ResponseMessage delete(Integer id){
		ResponseMessage result = new ResponseMessage();
		Song songDB = repository.findById(id).orElse(null);
		result.setDate(new Date());
		if(songDB != null) {
			repository.deleteById(id);
			result.setMessage("Cancion eliminada correctamente");
			result.setState(true);
		}else {
			result.setMessage("Ocurrio un error");
			result.setState(false);
		}
		
	return result;
	}
	
	
	public List<Song> getFavorite(){
		return repository.findByFavorite();
	}
}
