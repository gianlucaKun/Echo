package com.echo.mapper;

import com.echo.dto.ArtistDto;
import com.echo.entity.Artist;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { SongMapper.class })
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    @Mapping(target = "songs", ignore = true) // Evitare cicli infiniti
    ArtistDto toDto(Artist artist);

    @Mapping(target = "songs", ignore = true) // Evitare cicli infiniti
    Artist toEntity(ArtistDto artistDto);
    
    List<Artist> toEntityList(List<ArtistDto> artistDto);
    
    List<ArtistDto> toDtoList(List<Artist> artist);
}
