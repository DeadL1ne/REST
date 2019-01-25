package com.example.SingerService.dao;

import com.example.SingerService.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerDAO extends JpaRepository<Singer, Long> {

    Singer findSingerById(Long id);

    //List<Singer> findAll();
}
