package com.satellite.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.satellite.mapper.GenderMapper;
import com.satellite.mapper.SongMapper;
import com.satellite.mapper.util.MapperUtil;
import com.satellite.model.Gender;
import com.satellite.model.GenderxSong;
import com.satellite.model.ResponseMessage;
import com.satellite.model.Song;
import com.satellite.repository.IGender;
import com.satellite.repository.ISong;


@Service
public class GenderServices {
	
	@Autowired
	private IGender repository;
	
	@Autowired
	private ISong songRespository;
	
	
	
	
	public List<Gender> list(){
		return (List<Gender>) repository.findAll();
		
	}
	
	public GenderxSong getGenderxSongbyId(Integer id) {
		
		GenderxSong result = new GenderxSong();
		Gender gender = repository.findById(id).orElse(null);
		if(gender != null) {
			List<SongMapper> songs = MapperUtil.converToSongMapper(songRespository.findByGender(gender));
			result.setGender(gender);
			result.setSongsList(songs);
		}
		
		return result;
	}
	
	public Gender genderByType(String type) {
		Gender genderDB = repository.findByType(type).orElse(null);
		if(genderDB != null) {
			return genderDB;
		}
	
		return null;
	}
	
	
	public Gender insert(GenderMapper g) {
			Gender obj = new Gender(g.getIdGender(), g.getType(), g.getDescription(), g.getColor_code());
			try {
				return repository.save(obj);
			}catch(Exception e){
				return null;
			}
	}
	
	
	public Gender findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	

	public Gender update(GenderMapper g) {
		Gender  genderDB = repository.findById(g.getIdGender()).orElse(null);
		if(genderDB != null) {
			genderDB.setType(g.getType());
			genderDB.setDescription(g.getDescription());
			genderDB.setColor_code(g.getColor_code());
			return repository.save(genderDB);
		}
		return null;		
	}
	
	
	public ResponseMessage delete(Integer id){
		ResponseMessage result = new ResponseMessage();
		Gender genderDB = repository.findById(id).orElse(null);
		result.setDate(new Date());
		if(genderDB != null) {
			repository.deleteById(id);
			result.setMessage("Genero eliminado");
			result.setState(true);
		}else {
			result.setMessage("An error in delete Gender");
			result.setState(false);
		}
		
	return result;
	}
		
}
