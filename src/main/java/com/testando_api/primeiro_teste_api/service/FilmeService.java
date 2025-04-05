package com.testando_api.primeiro_teste_api.service;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.api.UrlApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.model.FilmeModel;

public class FilmeService implements UrlApi
{
    private FilmeModel filme;
    public void carregarDados(IDados dados, OmdbApi omdbApi, String filme)
    {
        String urlContenadaSerie = urlOmdb + filme.replace(" ", "+");
        omdbApi.criarApi(urlContenadaSerie);

        if(!omdbApi.getBody().contains("\"Type\":\"movie\"")) throw new RuntimeException("Erro: ao buscar filme\n");

        this.filme = dados.receberDadosDo(FilmeModel.class, omdbApi.getBody());
    }

    public void mostrarFilme(IDados dados)
    {
        dados.mostrarJsonDo(filme);
    }
}
