package com.echo.mapper;

import com.echo.dto.SongDto;
import com.echo.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    SongDto ToDTO(Song song);

    Song ToEntity(SongDto songDto);
}
