package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
