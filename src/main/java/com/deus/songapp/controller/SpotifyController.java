package com.deus.songapp.controller;

import com.deus.songapp.dto.SearchResultDto;
import com.deus.songapp.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/search")
    public SearchResultDto search(@RequestParam String searchTerm, String type) {
        return spotifyService.search(searchTerm, type);
    }
}