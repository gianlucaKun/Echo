package com.echo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.echo.dto.AlbumDto;
import com.echo.entity.Album;

@Mapper
public interface AlbumMapper {

	@Mapping(source = "artistId", target = "artist.id")
	Album toEntity ( AlbumDto dto );
	
	@Mapping(source = "artist.id", target = "artistId")
	AlbumDto toDto ( Album album );
}
