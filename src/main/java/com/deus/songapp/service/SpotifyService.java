package com.deus.songapp.service;

import com.deus.songapp.dto.SearchRequest;
import com.deus.songapp.dto.SearchResponse;
import com.deus.songapp.dto.SearchResultDto;
import com.deus.songapp.dto.SpotifyTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyService {

    @Autowired
    private RestTemplate restTemplate;

    public SearchResultDto search(String searchTerm, String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getBearerToken());

        SearchResponse response = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + searchTerm + "&type=" + type, HttpMethod.GET, new HttpEntity(headers), SearchResponse.class).getBody();

        response.getTracks();
        return null;
    }

    private String getBearerToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic NWQxMTNmNTNjYjBhNDY4Njg4ODhkMmEwZWMyYTdlOGI6OTA0ODQ1OTNiZjY3NDUwNzkzMjc5YWNkOTliZjY1MDc=");
        return restTemplate.postForEntity("https://accounts.spotify.com/api/token", new HttpEntity<>("grant_type=client_credentials", headers), SpotifyTokenResponse.class).getBody().getAccess_token();

    }
}
