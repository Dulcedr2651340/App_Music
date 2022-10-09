package com.satellite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.satellite.model.Gender;
import com.satellite.model.Song;

@Repository
public interface ISong extends CrudRepository<Song, Integer>{
	
	List<Song> findByGender(Gender gender);
	@Query(value = "select * from Song where is_favorite = 1", nativeQuery = true)
	List<Song> findByFavorite();
}
