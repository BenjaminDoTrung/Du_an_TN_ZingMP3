package com.example.du_an_tn_zingmp_3.controller;
import com.example.du_an_tn_zingmp_3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;
}
