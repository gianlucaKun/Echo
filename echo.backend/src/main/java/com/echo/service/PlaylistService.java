package com.echo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.dto.PlaylistDto;
import com.echo.entity.Playlist;
import com.echo.entity.Song;
import com.echo.mapper.PlaylistMapper;
import com.echo.repository.PlaylistRepository;
import com.echo.repository.SongRepository;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;
    
    @Autowired
    private PlaylistMapper playlistMapper;

    public PlaylistDto createPlaylist(Playlist playlist) {
        return playlistMapper.toDto(playlistRepository.save(playlist));
    }

    public PlaylistDto getPlaylist(Long id) {
        Playlist finded = playlistRepository.findById(id).orElse(null);
        
        if ( finded != null) {
        	return playlistMapper.toDto(finded);
        } 
        
        return null;
    }

    public List<PlaylistDto> getAllPlaylists() {
        return playlistMapper.toDtoList(playlistRepository.findAll());
    }

    public PlaylistDto updatePlaylist(Long id, Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.setName(playlistDetails.getName());
        return  playlistMapper.toDto(playlistRepository.save(playlist));
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    public PlaylistDto addSongsToPlaylist(Long playlistId, Set<Long> songIds) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        Set<Song> songs = new HashSet<>(songRepository.findAllById(songIds));
        playlist.getSongs().addAll(songs);
        return playlistMapper.toDto(playlistRepository.save(playlist));
    }
}