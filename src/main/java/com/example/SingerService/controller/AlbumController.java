package com.example.SingerService.controller;

import com.example.SingerService.dto.AlbumDTO;
import com.example.SingerService.entity.Album;
import com.example.SingerService.service.impl.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = AlbumController.BASE_PATH)
@Api(value = "Album managment")
public class AlbumController {

    public static final String BASE_PATH = "album";

    @Autowired
    private AlbumService albumService;

    @PostMapping(BASE_PATH)
    @ApiOperation(value = "createAlbum")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = AlbumDTO.class),
    })
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody Album album){
        return new ResponseEntity(albumService.createAlbum(album), HttpStatus.OK);
    }

    @DeleteMapping(BASE_PATH+"/{albumId}")
    @ApiOperation(value = "deleteAlbum")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted", response = AlbumDTO.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<?> deleteAlbum(@PathVariable(value = "albumId") Long id) {
        try {
            albumService.deleteAlbum(id);
        }catch (NullPointerException ex){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
