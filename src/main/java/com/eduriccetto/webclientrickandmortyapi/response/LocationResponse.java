package com.eduriccetto.webclientrickandmortyapi.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {

    private String id;
    private String name;
    private String type;
    private List<String> residentrs;
    private String url;
}
