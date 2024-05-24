package com.echo.mapper;

import com.echo.dto.SongDto;
import com.echo.entity.Song;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ArtistMapper.class })
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    @Mapping(source = "artist.id", target = "artistId")
    @Mapping(source = "album.id", target = "albumId")
    SongDto songToSongDto(Song song);

    @Mapping(source = "artistId", target = "artist.id")
    @Mapping(source = "albumId", target = "album.id")
    Song songDtoToSong(SongDto songDto);

    List<Song> toEntityList(List<SongDto> songDto);
    List<SongDto> toDtoList(List<Song> song);
}


/*
    TesseratoMapper INSTANCE = Mappers.getMapper(TesseratoMapper.class);
    
    @Mapping(source = "libri", target = "libri")
    Tesserato toEntity(TesseratoDTO tesseratoDTO);
    
    @Mapping(source = "libri", target = "libri")
    TesseratoDTO toDTO(Tesserato tesserato);

    List<TesseratoDTO> toDTOList(List<Tesserato> tesseratoList);

    List<Tesserato> toEntityList(List<TesseratoDTO> tesseratoDTOList);
    
    default List<Libro> mapLibriDTOToLibri(List<LibroDTO> libroDTOList) {
        if (libroDTOList == null) {
            return Collections.emptyList();
        }
    	return libroDTOList.stream()
                           .map(libroDTO -> LibroMapper.INSTANCE.toEntity(libroDTO))
                           .collect(Collectors.toList());
    }

    default List<LibroDTO> mapLibriToLibriDTO(List<Libro> libroList) {
        if (libroList == null) {
            return Collections.emptyList();
        }
    	return libroList.stream()
                        .map(libro -> LibroMapper.INSTANCE.toDTO(libro))
                        .collect(Collectors.toList());
    }
 */
