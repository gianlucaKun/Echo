package com.echo.dto;

import java.util.Collection;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class SongDto {
    private Long id;
    private String title;
    private Long albumId;
    private Long artistId;
    @JsonIgnore // Ignorare durante la serializzazione per evitare cicli
    private Collection<ArtistDto> artists;
}
