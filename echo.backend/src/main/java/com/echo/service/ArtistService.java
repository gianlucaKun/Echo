package com.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.dto.ArtistDto;
import com.echo.entity.Artist;
import com.echo.mapper.ArtistMapper;
import com.echo.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository aRepository;
	@Autowired
	private ArtistMapper aMapper;
	
	public ArtistDto createArtist(Artist artist) {

		Artist saved = aRepository.save(artist);
		return aMapper.toDto(saved);
	}

	public List<ArtistDto> findAll() {
		
		List<Artist> artistList = aRepository.findAll();
		return aMapper.toDtoList(artistList);
	}

}
