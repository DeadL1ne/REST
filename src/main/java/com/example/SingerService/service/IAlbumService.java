package com.example.SingerService.service;

import com.example.SingerService.dto.AlbumDTO;
import com.example.SingerService.entity.Album;
import org.springframework.http.ResponseEntity;

public interface IAlbumService {

    void deleteAlbum(Long id);

    AlbumDTO updateAlbum(Long id, Album albumRequest);

    AlbumDTO createAlbum(Album album);
}
