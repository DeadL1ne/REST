package com.example.SingerService.lastFmClient.dao;

import com.example.SingerService.lastFmClient.dto.ArtistDTO;
import com.example.SingerService.lastFmClient.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistDAO extends JpaRepository<Artist, Long> {

}
