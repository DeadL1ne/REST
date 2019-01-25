package com.example.SingerService.dto;

import com.example.SingerService.entity.Album;
import com.example.SingerService.entity.Singer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SingerDTO {

    public SingerDTO(){}

    public SingerDTO(Singer singer){
        this.id = singer.getId();
        this.name = singer.getName();
        this.groupname = singer.getGroupname();
        this.country = singer.getCountry();
        this.startdate = singer.getStartdate();
        this.albums = singer.getAlbums();
    }

    private Long id;

    private String name;

    private String groupname;

    private String country;

    private Date startdate;

    private Set<Album> albums = new HashSet<Album>();

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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
