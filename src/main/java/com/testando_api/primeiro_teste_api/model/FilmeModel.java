package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.testando_api.primeiro_teste_api.deserializer.DoubleDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeModel
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

    @JsonAlias("Type")
    private String type;

}
