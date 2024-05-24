package com.echo.dto;

import lombok.Data;

@Data
public class SongDto {
    private Long id;
    private String title;
    private AlbumDto album;
    private ArtistDto artist;
}
