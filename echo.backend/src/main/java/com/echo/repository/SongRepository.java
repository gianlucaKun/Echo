package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long>{

}
