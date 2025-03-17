package com.testando_api.primeiro_teste_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeModel
{
    @JsonAlias("imdbID")
    private String id;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Episode")
    private String episode;

    @JsonAlias("imdbRating")
    private String rating;
}
