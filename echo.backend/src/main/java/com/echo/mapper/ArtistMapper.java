package com.echo.mapper;

import com.echo.dto.ArtistDto;
import com.echo.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    ArtistDto ToDTO(Artist artist);

    Artist ToEntity(ArtistDto artistDTO);
}
