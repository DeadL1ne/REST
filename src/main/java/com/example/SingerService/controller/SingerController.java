package com.example.SingerService.controller;

import com.example.SingerService.dto.SingerDTO;
import com.example.SingerService.dto.SingerOnlyNameDTO;
import com.example.SingerService.entity.Singer;
import com.example.SingerService.service.impl.SingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController(value = SingerController.BASE_PATH)
@Api(value = "Singer managment")
public class SingerController {

    public static final String BASE_PATH = "singer";

    @Autowired
    private SingerService service;

    @GetMapping(BASE_PATH + "/{singerId}")
    @ApiOperation(value = "getSingerById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SingerDTO.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<SingerDTO> getSingerById(@PathVariable(value = "singerId") Long id) {
        try {
            return new ResponseEntity(service.getSingerById(id), HttpStatus.OK);
        }catch (NullPointerException ex){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(BASE_PATH + "/allSingers")
    @ApiOperation(value = "getAllSingers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SingerOnlyNameDTO.class)
    })
    public ResponseEntity<List<SingerDTO>> getAllSingers() {
        return new ResponseEntity(service.getAllSingers(), HttpStatus.OK);
    }

    @PostMapping(BASE_PATH)
    @ApiOperation(value = "createSinger")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = SingerDTO.class),
    })
    public ResponseEntity<SingerDTO> createSinger(@RequestBody Singer singer) {
        return new ResponseEntity(service.createSinger(singer), HttpStatus.OK);
    }

    @PutMapping(BASE_PATH + "/{singerId}")
    @ApiOperation(value = "updateSinger")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Singer.class),
    })
    public ResponseEntity<SingerDTO> updateSinger(@PathVariable(value = "singerId") Long id, @RequestBody Singer singerRequest) {
        try{
            return new ResponseEntity(service.updateSinger(id, singerRequest), HttpStatus.OK);
        } catch (NullPointerException ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
