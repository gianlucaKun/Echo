package com.echo.entity;

import java.util.Collection;
import java.util.HashSet;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Artist artist;

    @ManyToMany(mappedBy = "songs") // Utilizza mappedBy per specificare che la relazione è mappata dall'entità Song
    private Collection<Artist> artists = new HashSet<>();
    
    @ManyToMany(mappedBy = "songs")
    private Collection<Playlist> playlists = new HashSet<>();
}
