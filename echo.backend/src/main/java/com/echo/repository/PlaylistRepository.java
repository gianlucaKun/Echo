package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
