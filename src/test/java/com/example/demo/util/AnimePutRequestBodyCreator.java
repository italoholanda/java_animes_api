package com.example.demo.util;

import com.example.demo.request.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createUpdatedAnime().getId())
                .name(AnimeCreator.createUpdatedAnime().getName())
                .build();
    }
}
