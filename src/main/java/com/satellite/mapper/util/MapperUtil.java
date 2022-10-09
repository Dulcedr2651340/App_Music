package com.satellite.mapper.util;

import java.util.ArrayList;
import java.util.List;

import com.satellite.mapper.GenderMapper;
import com.satellite.mapper.SongMapper;
import com.satellite.model.Gender;
import com.satellite.model.Song;

public class MapperUtil {

	public static List<SongMapper> converToSongMapper(List<Song> songList){
		List<SongMapper> result = new ArrayList<>();
		for(Song s: songList) {
			result.add(new SongMapper(s));
		}
		
		return result;
	}
	
	public static List<GenderMapper> converToGenderMapper(List<Gender> genderList){
		List<GenderMapper> result = new ArrayList<>();
		for(Gender g: genderList) {
			result.add(new GenderMapper(g));
		}
		
		return result;
	}
}
