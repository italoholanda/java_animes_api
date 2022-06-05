package com.example.demo.util;

import com.example.demo.domain.Anime;

public class AnimeCreator {
    public static Anime createAnime() {
        return Anime.builder().name("Gantz").build();
    }
}
