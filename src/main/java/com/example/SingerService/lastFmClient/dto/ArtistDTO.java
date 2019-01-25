package com.example.SingerService.lastFmClient.dto;

import com.example.SingerService.lastFmClient.entity.Artist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistDTO {

   public ArtistDTO(){}

   public ArtistDTO(Artist artist){
       this.name = artist.getName();
       this.listeners = artist.getListeners().toString();
       this.url = artist.getUrl();
   }

   private String name;

   private String listeners;

   private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
