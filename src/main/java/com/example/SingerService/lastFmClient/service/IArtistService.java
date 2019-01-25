package com.example.SingerService.lastFmClient.service;

import com.example.SingerService.lastFmClient.dto.ArtistDTO;
import com.example.SingerService.lastFmClient.entity.Artist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArtistService {

    ResponseEntity<List<ArtistDTO>> getArtistsFromLastFm(String name);
}
