package com.echo.dto;

import lombok.Data;

@Data
public class AlbumDto {
    private Long id;
    private String title;
    private Long artistId;
}
