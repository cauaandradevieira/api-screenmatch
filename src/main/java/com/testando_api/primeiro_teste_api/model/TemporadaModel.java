package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class TemporadaModel
{
    @JsonAlias("Title")
    private String title;

    @JsonAlias("Season")
    private int season;

    @JsonAlias("Episodes")
    private final List<EpisodeModel> episodes = new ArrayList<>();
}
