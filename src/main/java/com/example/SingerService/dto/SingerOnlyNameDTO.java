package com.example.SingerService.dto;

import com.example.SingerService.entity.Singer;

public class SingerOnlyNameDTO {

    public SingerOnlyNameDTO(Singer singer){
        this.id = singer.getId();
        this.name = singer.getName();
    }

    private Long id;

    private String name;

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
}
