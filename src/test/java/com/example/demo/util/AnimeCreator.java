package com.example.demo.util;

import com.example.demo.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved() {
        return Anime.builder().name("Gantz").build();
    }

    public static Anime createValidAnime() {
        return Anime.builder().name("Gantz").build();
    }

    public static Anime createUpdatedAnime() {
        return Anime.builder().name("Shingeki No Kyojin").id(1L).build();
    }
}
