package com.deus.songapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
    private Tracks tracks;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tracks {
        private String href;
        private Integer limit;
        private String next;
        private Integer offset;
        private List<Item> items;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private List<Artist> artists;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Artist {
        private String name;
    }
}
