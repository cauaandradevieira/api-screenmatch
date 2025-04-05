package com.testando_api.primeiro_teste_api.service;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.api.UrlApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.model.SerieModel;
import com.testando_api.primeiro_teste_api.model.TemporadaModel;

import java.util.ArrayList;
import java.util.List;

public class TemporadaService implements UrlApi
{
    public List<TemporadaModel> carregarDados(OmdbApi omdbApi, IDados dados, String url, SerieModel serie)
    {
        List<TemporadaModel> listaTemporada = new ArrayList<>();

        for (int i = 1; i <= serie.getTotalSeasons(); i++) {
            omdbApi.criarApi(url+"&season="+i);
            listaTemporada.add(dados.receberDadosDo(TemporadaModel.class, omdbApi.getBody()));
        }

        return listaTemporada;
    }

    public void mostrarTemporada(SerieModel serieModel, IDados dados)
    {
        serieModel.getListaTemporadas().stream()
                .peek(t -> System.out.println("=-=-=-=-=-=-=-=-= Temporada " + t.getSeason() + " =-=-=-=-=-=-=-=-="))
                .flatMap(e -> e.getListaEpisodios().stream())
                .forEach(dados::mostrarJsonDo);

    }
}
