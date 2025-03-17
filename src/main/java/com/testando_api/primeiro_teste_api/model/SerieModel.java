package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieModel
{
    @JsonIgnore
    private final List<TemporadaModel> temporadas = new ArrayList<>();

    @JsonAlias("imdbID")
    private String id;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Runtime")
    private String duration;

    @JsonAlias("totalSeasons")
    private String totalSeasons;

    @JsonAlias("imdbRating")
    private String avaliation;

    @JsonAlias("Type")
    private String type;

    public SerieModel(String id, String title, String duration, String avaliation, String type, String totalSeasons) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.avaliation = avaliation;
        this.type = type;
        this.totalSeasons = totalSeasons;
    }

    public SerieModel(String title, String duration, String totalSeasons, String avaliation, String type) {
        this.title = title;
        this.duration = duration;
        this.totalSeasons = totalSeasons;
        this.avaliation = avaliation;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SerieModel(" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", totalSeasons='" + totalSeasons + '\'' +
                ", avaliation='" + avaliation + '\'' +
                ", type='" + type + '\'' +
                ')';
    }
}
