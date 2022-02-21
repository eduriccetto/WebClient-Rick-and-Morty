package com.eduriccetto.webclientrickandmortyapi.controller;

import com.eduriccetto.webclientrickandmortyapi.client.RickAndMortyClient;
import com.eduriccetto.webclientrickandmortyapi.response.CharacterResponse;
import com.eduriccetto.webclientrickandmortyapi.response.EpisodeResponse;
import com.eduriccetto.webclientrickandmortyapi.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
        return rickAndMortyClient.findACharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id){
        return rickAndMortyClient.findALocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
        return rickAndMortyClient.findAEpisodeById(id);
    }

}
