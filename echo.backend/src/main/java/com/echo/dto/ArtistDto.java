package com.echo.dto;

import java.util.Set;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class ArtistDto {
    private Long id;
    private String fullname;
    @JsonIgnore // Ignorare durante la serializzazione per evitare cicli
    private Set<SongDto> songs;
}
