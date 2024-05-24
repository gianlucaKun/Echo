package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
