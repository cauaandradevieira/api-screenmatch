package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testando_api.primeiro_teste_api.deserializer.IntegerDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemporadaModel
{
    @JsonAlias("Title")
    private String tittle;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonAlias("Season")
    private Integer season;

    @JsonAlias("Episodes")
    private List<EpisodeModel> listaEpisodios = new ArrayList<>();
}
