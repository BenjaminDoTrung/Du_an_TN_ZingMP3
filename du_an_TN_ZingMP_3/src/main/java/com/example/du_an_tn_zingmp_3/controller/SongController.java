package com.example.du_an_tn_zingmp_3.controller;
import com.example.du_an_tn_zingmp_3.model.Songs;
import com.example.du_an_tn_zingmp_3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping
    public ResponseEntity<Iterable<Songs>> findAll(){
        return new ResponseEntity<>(iSongService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Songs>> findOne(@PathVariable("id")Long id){
        return new ResponseEntity<>(iSongService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> update(@RequestBody Songs songs){
        iSongService.save(songs);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> createSong(@RequestBody Songs songs){
        iSongService.save(songs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        iSongService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Songs>> findByName(@PathVariable String name){
        return new ResponseEntity<>(iSongService.findByNameSong(name),HttpStatus.OK);
    }
    @GetMapping("/find_all_by_name/{name}")
    public ResponseEntity<Iterable<Songs>> findAllByNameSong(@PathVariable String nameSong){
        return new ResponseEntity<>(iSongService.findAllByNameSong(nameSong), HttpStatus.OK);
    }
    @PutMapping("/add_play_list/{idPlayList}/{idSong}")
    public ResponseEntity<?> addPlayList(@PathVariable("idPlayList")Long idPlayList,
                                         @PathVariable("idSong")Long idSong){
        iSongService.addPlayList(idPlayList, idSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
