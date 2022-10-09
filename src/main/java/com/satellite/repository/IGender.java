package com.satellite.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.satellite.model.Gender;


@Repository
public interface IGender extends CrudRepository<Gender, Integer>{
	
	Optional<Gender> findByType(String type);

}
