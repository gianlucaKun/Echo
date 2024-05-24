package com.echo.mapper;

import com.echo.dto.ArtistDto;
import com.echo.entity.Artist;
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
}
