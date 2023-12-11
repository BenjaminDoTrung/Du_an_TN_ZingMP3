package com.example.du_an_tn_zingmp_3.controller;

import com.example.du_an_tn_zingmp_3.model.SongTypes;
import com.example.du_an_tn_zingmp_3.service.ISongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songTypes")
public class SongTypeController {
    @Autowired
    private ISongTypeService iSongTypeService;

    @GetMapping
    public ResponseEntity<Iterable<SongTypes>> findAllSongType(){
        return new ResponseEntity<>(iSongTypeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SongTypes>> findOneSongType(@PathVariable("id") Long id){
        return new ResponseEntity<>(iSongTypeService.findById(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> createSongType(@RequestBody SongTypes songTypes){
        iSongTypeService.save(songTypes);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
