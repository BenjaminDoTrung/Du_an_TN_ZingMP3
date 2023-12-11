package com.example.du_an_tn_zingmp_3.controller;

import com.example.du_an_tn_zingmp_3.model.PlayList;
import com.example.du_an_tn_zingmp_3.service.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playLists")
public class PlayListController {
    @Autowired
    private IPlayListService iPlayListService;

    @GetMapping
    public ResponseEntity<Iterable<PlayList>> findAllPlayList(){
        return new ResponseEntity<>(iPlayListService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<PlayList>> findOnePlayList(@PathVariable("id") Long id){
        return new ResponseEntity<>(iPlayListService.findById(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> createPlayList(@RequestBody PlayList playList){
        iPlayListService.save(playList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
