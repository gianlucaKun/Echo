package com.echo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.echo.dto.PlaylistDto;
import com.echo.entity.Playlist;

@Mapper
public interface PlaylistMapper {
	
	@Mapping(source = "userId", target = "user.id")
	@Mapping(target = "songs", ignore = true)
	Playlist toEntity (PlaylistDto dto);

	@Mapping(source = "user.id", target = "userId")
	@Mapping(target = "songs", ignore = true)
	PlaylistDto toDto (Playlist playlist);
	
	List<Playlist> toEntityList (List<PlaylistDto> dto);
	
	List<PlaylistDto> toDtoList (List<Playlist> playlist);

}
