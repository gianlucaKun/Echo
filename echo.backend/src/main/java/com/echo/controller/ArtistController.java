package com.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.ArtistDto;
import com.echo.entity.Artist;
import com.echo.service.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/artist")
public class ArtistController {

	
	@Autowired
	private ArtistService artistService;
	
	
	@PostMapping("/create")
	public ArtistDto createArtist(@RequestBody Artist artist) {
		
		return artistService.createArtist(artist);
	}
	
	@GetMapping("/findAll")
	public List<ArtistDto> findAll() {
		return artistService.findAll();
	}
	
	
	
}
