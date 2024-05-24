package com.echo.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto {

	private Long id;

	private String name;

	private Long userId;

	@JsonIgnore // Ignorare durante la serializzazione per evitare cicli
	private Set<SongDto> songs;

}
