package com.echo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.PlaylistDto;
import com.echo.entity.Playlist;
import com.echo.service.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public PlaylistDto createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping("/{id}")
    public PlaylistDto getPlaylist(@PathVariable Long id) {
        
    	PlaylistDto finded = playlistService.getPlaylist(id);
    	
    	return finded;
    }

    @GetMapping
    public List<PlaylistDto> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistDto> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlistDetails) {
        Playlist updatedPlaylist = playlistService.updatePlaylist(id, playlistDetails);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{playlistId}/songs")
    public ResponseEntity<PlaylistDto> addSongsToPlaylist(@PathVariable Long playlistId, @RequestBody Set<Long> songIds) {
        Playlist updatedPlaylist = playlistService.addSongsToPlaylist(playlistId, songIds);
        return ResponseEntity.ok(updatedPlaylist);
    }
}