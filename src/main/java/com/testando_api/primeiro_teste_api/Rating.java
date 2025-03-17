package com.testando_api.primeiro_teste_api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testando_api.primeiro_teste_api.model.SerieModel;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Rating(@JsonAlias("Ratings") List<SerieModel> ratings) {
}
