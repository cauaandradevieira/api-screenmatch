package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testando_api.primeiro_teste_api.deserializer.DoubleDeserializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeModel
{
    @JsonAlias("imdbID")
    private String id;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Released")
    private String date;

    @JsonAlias("Episode")
    private String episode;

    @JsonDeserialize(using = DoubleDeserializer.class)
    @JsonAlias("imdbRating")
    private Double avaliation;

}
