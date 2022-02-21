package com.eduriccetto.webclientrickandmortyapi.client;

import com.eduriccetto.webclientrickandmortyapi.response.CharacterResponse;
import com.eduriccetto.webclientrickandmortyapi.response.EpisodeResponse;
import com.eduriccetto.webclientrickandmortyapi.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findACharacterById(String id){

        log.info("Buscando o personagem de id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parametros informados!")))
                .bodyToMono(CharacterResponse.class);

    }

    public Mono<LocationResponse> findALocationById(String id){

        log.info("Buscando a localização de id [{}]", id);
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parametros informados!")))
                .bodyToMono(LocationResponse.class);

    }

    public Mono<EpisodeResponse> findAEpisodeById(String id){

        log.info("Buscando o episodio pelo id [{}]", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parametros informados!")))
                .bodyToMono(EpisodeResponse.class);

    }

}
