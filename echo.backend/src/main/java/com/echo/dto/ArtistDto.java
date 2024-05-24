package com.echo.dto;

import java.util.Set;
import lombok.Data;

@Data
public class ArtistDto {
    private Long id;
    private String fullname;
    private Set<SongDto> songs;
}
