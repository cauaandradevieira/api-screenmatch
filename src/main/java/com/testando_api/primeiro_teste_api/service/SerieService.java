package com.testando_api.primeiro_teste_api.service;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.api.UrlApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.model.SerieModel;
import com.testando_api.primeiro_teste_api.model.TemporadaModel;
import com.testando_api.primeiro_teste_api.ordenar.OrdenarSerie;

import java.util.List;

public class SerieService implements UrlApi
{
    private SerieModel serieModel;
    private TemporadaService temporadaService = new TemporadaService();
    private OrdenarSerie ordenarSerie = new OrdenarSerie();

    public void carregarDados(IDados dados, OmdbApi omdbApi, String serie)
    {
        String urlContenadaSerie = urlOmdb + serie.replace(" ", "+");
        omdbApi.criarApi(urlContenadaSerie);

        if(!omdbApi.getBody().contains("\"Type\":\"series\"")) throw new RuntimeException("Erro: ao buscar serie\n");

        SerieModel serieModel = dados.receberDadosDo(SerieModel.class, omdbApi.getBody());

        List<TemporadaModel> listaTemporada = temporadaService.carregarDados(omdbApi,dados,urlContenadaSerie,serieModel);
        serieModel.setListaTemporadas(listaTemporada);

        this.serieModel = serieModel;
    }

    public void mostrarSerie(IDados dados)
    {
        dados.mostrarJsonDo(serieModel);
    }

    public void mostrarTemporada(IDados dados)
    {
        temporadaService.mostrarTemporada(serieModel, dados);
    }

    public void exibirEpisodiosPorAvaliacao(String ordem, IDados dados)
    {
        ordenarSerie.ordenarPorAvaliação(serieModel, dados, ordem);
    }

    public void mostrarMelhores10Episodios(String ordem, IDados dados)
    {
        ordenarSerie.ordenarPorAvaliaçãoTop10(serieModel, dados, ordem);
    }

}
