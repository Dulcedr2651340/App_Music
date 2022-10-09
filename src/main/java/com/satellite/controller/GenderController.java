package com.satellite.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satellite.mapper.GenderMapper;
import com.satellite.mapper.util.MapperUtil;
import com.satellite.model.Gender;
import com.satellite.model.GenderxSong;
import com.satellite.model.ResponseData;
import com.satellite.model.ResponseMessage;
import com.satellite.services.GenderServices;


@RestController
@RequestMapping(path = "api/gender")
public class GenderController {
	
	@Autowired
	private GenderServices service;
	
	@GetMapping
	public ResponseEntity<ResponseData<GenderMapper>> list(){
		List<Gender> genderDB = service.list();
		return new ResponseEntity<>(new ResponseData<>("gender", MapperUtil.converToGenderMapper(genderDB)), HttpStatus.OK);
	}

	@GetMapping("/genderxsong/{id}")
	public ResponseEntity<ResponseData<GenderxSong>> genderxsong(@PathVariable("id") Integer id){
		
		GenderxSong genderxSong = service.getGenderxSongbyId(id);
		if(genderxSong.getGender() != null) {
			return new ResponseEntity<>(new ResponseData<>("GenderxSong", genderxSong),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ResponseData<>("GenderxSong", null),HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getbyType/{type}")
	public ResponseEntity<ResponseData<GenderMapper>> findByType(@PathVariable("type") String type){
			Gender genderDB = service.genderByType(type);
			if(genderDB != null) {
				return new ResponseEntity<>(new ResponseData<>("gender", new GenderMapper(genderDB)), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<GenderMapper>> findById(@PathVariable("id") Integer id){
			Gender genderDB = service.findById(id);
			if(genderDB != null) {
				return new ResponseEntity<>(new ResponseData<>("gender", new GenderMapper(genderDB)), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
	}
	
	@PostMapping
	public ResponseEntity<ResponseMessage> insert(@RequestBody GenderMapper gender){
		Gender genderInserted = service.insert(gender);
		ResponseMessage result = new ResponseMessage();
		result.setDate(new Date());
		if(genderInserted != null) {
			result.setMessage("Genero registrado correctamente");
			result.setState(true);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			result.setMessage("Ocurrio un error");
			result.setState(false);
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<ResponseMessage> update(@RequestBody GenderMapper gender){
		Gender genderUpdated = service.update(gender);
		ResponseMessage result = new ResponseMessage();
		result.setDate(new Date());
		if(genderUpdated != null) {
			result.setMessage("Genero actualizado correctamente");
			result.setState(true);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			result.setMessage("Ocurrio un error");
			result.setState(false);
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable("id") Integer id){
		ResponseMessage result = service.delete(id);
		if(result.getState()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}
	
	
}
