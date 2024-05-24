package com.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.SongDto;
import com.echo.entity.Song;
import com.echo.service.SongService;

@RestController
@RequestMapping("/song")
public class SongController {

	
	@Autowired
	private SongService songService;
	
	
	@PostMapping("/create")
	public SongDto createSong (@RequestBody Song song) {
		return songService.createSong(song);
	}
	
	@GetMapping("/findAll")
	public List<SongDto> findAll () {
		return songService.findAll();
	}
}
