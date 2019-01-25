package com.example.SingerService.dto;

import com.example.SingerService.entity.Album;
import com.example.SingerService.entity.Singer;
import java.util.Date;

public class AlbumDTO {

    private Long id;

    private String name;

    private Date releasedate;

    private Singer singer;

    public AlbumDTO(){}

    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.releasedate = album.getReleasedate();
        this.singer = album.getSinger();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
