package com.example.SingerService.service.impl;

import com.example.SingerService.dao.AlbumDAO;
import com.example.SingerService.dto.AlbumDTO;
import com.example.SingerService.dto.SingerDTO;
import com.example.SingerService.entity.Album;
import com.example.SingerService.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumDAO albumDAO;

    public void deleteAlbum(Long id) {
        try {
            albumDAO.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){
            throw new NullPointerException();
        }
    }

    public AlbumDTO updateAlbum(Long id, Album albumRequest) {
        try {
            Album album = albumDAO.findAlbumById(id);
            album.setName(albumRequest.getName());
            album.setSinger(albumRequest.getSinger());
            album.setReleasedate(albumRequest.getReleasedate());
            return new AlbumDTO(albumDAO.save(album));
        }
        catch (EmptyResultDataAccessException ex){
            throw new NullPointerException();
        }
    }

    public AlbumDTO createAlbum(Album album) {
        return new AlbumDTO(albumDAO.save(album));
    }

    public boolean isAlbumExist(Long id){
        if(id == null) {
            return true;
        }
        Optional<Album> album = albumDAO.findById(id);
        return album == null;
    }
}
