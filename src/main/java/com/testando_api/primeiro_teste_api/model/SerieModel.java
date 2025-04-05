package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testando_api.primeiro_teste_api.deserializer.DoubleDeserializer;
import com.testando_api.primeiro_teste_api.deserializer.IntegerDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieModel
{
    @JsonAlias("imdbID")
    private String id;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Runtime")
    private String duration;

    @JsonDeserialize(using = DoubleDeserializer.class)
    @JsonAlias("imdbRating")
    private Double avaliation;

    @JsonDeserialize(using = IntegerDeserializer.class)
    @JsonAlias("totalSeasons")
    private Integer totalSeasons;

    @JsonAlias("Type")
    private String type;

    @JsonIgnore
    private List<TemporadaModel> listaTemporadas = new ArrayList<>();
}
