package com.satellite.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satellite.mapper.SongMapper;
import com.satellite.mapper.util.MapperUtil;
import com.satellite.model.ResponseData;
import com.satellite.model.ResponseMessage;
import com.satellite.model.Song;
import com.satellite.services.SongServices;



@RestController
@RequestMapping(path="api/song")
public class SongController {

	@Autowired
	private SongServices service;
	
	@GetMapping
	public ResponseEntity<ResponseData<SongMapper>> list(){
		List<Song> listDB = service.list();
		return new ResponseEntity<>(new ResponseData<>("song", MapperUtil.converToSongMapper(listDB)), HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Song>> findById(@PathVariable("id") Integer id){
			Song songDB = service.findById(id);
			if(songDB != null) {
				return new ResponseEntity<>(new ResponseData<>("song",songDB), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
	}
	
	@PostMapping
	public ResponseEntity<ResponseMessage> insert(@RequestBody SongMapper song){
		Song songInserted = service.insert(song);
		ResponseMessage result = new ResponseMessage();
		if(songInserted != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			result.setMessage("Ocurrio un error");
			result.setState(false);
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<ResponseMessage> update(@RequestBody SongMapper song){
		
		Song songUpdated = service.update(song);
		ResponseMessage result = new ResponseMessage();
		if(songUpdated != null) {
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
	
	@GetMapping("/favorite")
	public ResponseEntity<ResponseData<SongMapper>> getFavorite(){
		List<Song> listDB = service.getFavorite();
		return new ResponseEntity<>(new ResponseData<>("song", MapperUtil.converToSongMapper(listDB)), HttpStatus.OK);
	}

	
}
