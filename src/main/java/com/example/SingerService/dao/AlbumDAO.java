package com.example.SingerService.dao;

import com.example.SingerService.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDAO extends JpaRepository<Album, Long> {

    Album findAlbumById(Long id);
}
