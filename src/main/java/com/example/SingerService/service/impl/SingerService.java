package com.example.SingerService.service.impl;

import com.example.SingerService.dao.SingerDAO;
import com.example.SingerService.dto.SingerDTO;
import com.example.SingerService.dto.SingerOnlyNameDTO;
import com.example.SingerService.entity.Album;
import com.example.SingerService.entity.Singer;
import com.example.SingerService.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerDAO singerDAO;

    @Autowired
    private AlbumService albumService;

    public SingerDTO getSingerById(Long id) {
         return singerDAO.findById(id)
                 .map(singer -> new SingerDTO(singer))
                 .orElseThrow(() -> new NullPointerException());

    }

    public List<SingerOnlyNameDTO> getAllSingers() {
        List<SingerOnlyNameDTO> list = new ArrayList<>();
        singerDAO.findAll().forEach(singer -> list.add(new SingerOnlyNameDTO(singer)));
        return list;
    }

    public SingerDTO createSinger(Singer singer) {
        singer.getAlbums().forEach(album -> album.setSinger(singer));
        return new SingerDTO(singerDAO.save(singer));
    }

    public SingerDTO updateSinger(Long id, Singer singerRequest) {
        try {
            Singer singer = singerDAO.findSingerById(id);
            singer.setName(singerRequest.getName());
            singer.setGroupname(singerRequest.getGroupname());
            singer.setCountry(singerRequest.getCountry());
            deleteUnusedAlbums(singer.getAlbums(), singerRequest.getAlbums());
            updateAlbumsSet(singer, singerRequest.getAlbums());
            return new SingerDTO(singerDAO.save(singer));
        }catch (NullPointerException ex) {
            throw ex;
        }
    }

    private void deleteUnusedAlbums(Set<Album> currentAlbums, Set<Album> requestedAlbums){
        try {
            currentAlbums.forEach(album -> {
                if (isForDelete(album.getId(), requestedAlbums)) {
                    albumService.deleteAlbum(album.getId());
                }
            });
        }catch (NullPointerException ex){
            throw new NullPointerException();
        }
    }

    private boolean isForDelete(Long id, Set<Album> requstedAlbum) {
        for(Album album: requstedAlbum){
            if (album.getId() == id) {
                return false;
            }
        }
        return true;
    }

    private void updateAlbumsSet(Singer singer, Set<Album> requstedAlbum){
        try {
            requstedAlbum.forEach(album -> {
                album.setSinger(singer);
                if(albumService.isAlbumExist(album.getId()))
                    albumService.createAlbum(album);
                albumService.updateAlbum(album.getId(), album);
            });
        }catch (NullPointerException ex){
            throw ex;
        }
    }
}
