package com.example.SingerService.lastFmClient.service.impl;

import com.example.SingerService.lastFmClient.LastFmClient;
import com.example.SingerService.lastFmClient.dao.ArtistDAO;
import com.example.SingerService.lastFmClient.dto.ArtistDTO;
import com.example.SingerService.lastFmClient.entity.Artist;
import com.example.SingerService.lastFmClient.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements IArtistService {

    @Autowired
    private ArtistDAO dao;

    @Autowired
    private LastFmClient lastFmClient;

    public ResponseEntity<List<ArtistDTO>> getArtistsFromLastFm(String name) {
        List<Artist> list = new ArrayList<>();
        lastFmClient.getArtistsByName(name).forEach(artist -> list.add(new Artist(artist)));
        dao.saveAll(list);
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
