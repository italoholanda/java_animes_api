package com.example.demo.client;

import com.example.demo.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    private static final String SERVICE_URL = "http://localhost:8080/animes";

    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity(SERVICE_URL.concat("/{id}"), Anime.class, 7);
        log.info(entity);

        Anime object = new RestTemplate().getForObject(SERVICE_URL.concat("/{id}"), Anime.class, 7);
        log.info(object);
    }
}
