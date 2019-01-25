package com.example.SingerService.service;

import com.example.SingerService.dto.SingerDTO;
import com.example.SingerService.dto.SingerOnlyNameDTO;
import com.example.SingerService.entity.Singer;

import java.util.List;

public interface ISingerService {

    SingerDTO getSingerById(Long id);

    List<SingerOnlyNameDTO> getAllSingers();

    SingerDTO createSinger(Singer singer);

    SingerDTO updateSinger(Long id, Singer singerRequest);



}
