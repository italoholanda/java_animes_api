package com.example.demo.client;

import com.example.demo.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

@Log4j2
public class SpringClient {
    private static final String SERVICE_URL = "http://localhost:8080/animes";

    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity(SERVICE_URL.concat("/{id}"), Anime.class, 7);
        log.info(entity);

        Anime object = new RestTemplate().getForObject(SERVICE_URL.concat("/{id}"), Anime.class, 7);
        log.info(object);

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange(SERVICE_URL.concat("/all"), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        log.info(exchange.getBody());


//          Anime dragonBallZ = Anime.builder().name("Dragon Ball Z").build();
//          Anime savedDragonBallZ = new RestTemplate().postForObject(SERVICE_URL.concat("/save"), dragonBallZ, Anime.class);
//          log.info("Saved anime {}", savedDragonBallZ);


        Anime samuraiChamploo = Anime.builder().name("Samurai Champloo").build();
        ResponseEntity<Anime> samuraiChamplooSaved = new RestTemplate().exchange(SERVICE_URL.concat("/save"), HttpMethod.POST, new HttpEntity<>(samuraiChamploo, createJsonHeader()), Anime.class);
        log.info("saved anime {}", samuraiChamplooSaved);

        Anime animeToBeUpdated = samuraiChamplooSaved.getBody();
        animeToBeUpdated.setName("Samurai Champloo 2");

        ResponseEntity<Void> samuraiChamplooUpdated = new RestTemplate().exchange(SERVICE_URL.concat("/replace"), HttpMethod.PUT, new HttpEntity<>(animeToBeUpdated, createJsonHeader()), Void.class);
        log.info(samuraiChamplooUpdated);

        ResponseEntity<Void> samuraiChamplooDeleted = new RestTemplate().exchange(SERVICE_URL.concat("/{id}/delete"), HttpMethod.DELETE, null, Void.class, animeToBeUpdated.getId());
        log.info(samuraiChamplooDeleted);
    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}

