package com.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.dto.SongDto;
import com.echo.entity.Song;
import com.echo.mapper.SongMapper;
import com.echo.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private SongMapper songMapper;
	
	public SongDto createSong (Song song) {
		
		Song saved = songRepository.save(song);
		
		return songMapper.songToSongDto(saved);
	}

	public List<SongDto> findAll() {
		List<Song> findlist = songRepository.findAll();
		
		return songMapper.toDtoList(findlist);
	}

}
