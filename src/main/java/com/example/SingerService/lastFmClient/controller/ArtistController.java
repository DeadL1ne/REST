package com.example.SingerService.lastFmClient.controller;

import com.example.SingerService.lastFmClient.dto.ArtistDTO;
import com.example.SingerService.lastFmClient.service.impl.ArtistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = ArtistController.BASE_PATH)
@Api(value = "Artist managment")
public class ArtistController {

    public static final String BASE_PATH = "artist";

    @Autowired
    private ArtistService service;

    @GetMapping(BASE_PATH + "/artists/{artistName}")
    @ApiOperation(value = "getArtistsFromLastFmByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ArtistDTO.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<List<ArtistDTO>> getArtistsFromLastFmByName(@PathVariable(name = "artistName") String name) {
        return service.getArtistsFromLastFm(name);
    }

}
