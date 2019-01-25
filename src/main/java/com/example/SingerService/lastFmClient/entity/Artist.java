package com.example.SingerService.lastFmClient.entity;

import com.example.SingerService.lastFmClient.dto.ArtistDTO;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {

    public Artist(){}

    public Artist(ArtistDTO artistDTO){
        this.name = artistDTO.getName();
        this.listeners = Long.valueOf(artistDTO.getListeners());
        this.url = artistDTO.getUrl();
    }

    @Id
    @GeneratedValue(generator = "artist_generator")
    @SequenceGenerator(
            name = "artist_generator",
            sequenceName = "artist_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;

    private Long listeners;

    private String url;

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

    public Long getListeners() {
        return listeners;
    }

    public void setListeners(Long listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
