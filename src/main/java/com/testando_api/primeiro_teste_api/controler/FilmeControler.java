package com.testando_api.primeiro_teste_api.controler;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.menu.IMenu;
import com.testando_api.primeiro_teste_api.service.FilmeService;
import com.testando_api.primeiro_teste_api.util.LeitorEntrada;

public class FilmeControler implements ITituloControler, IMenu
{
    private FilmeService filmeService = new FilmeService();
    private IDados dados;
    private OmdbApi omdbApi;

    public FilmeControler(IDados dados, OmdbApi omdbApi) {
        this.omdbApi = omdbApi;
        this.dados = dados;
    }

    @Override
    public void iniciar()
    {
        System.out.println("Digite a filme");
        String filme = LeitorEntrada.returnScannerString();

        filmeService.carregarDados(dados,omdbApi,filme);

        System.out.println(MENU_FILME);
        int escolha = LeitorEntrada.returnScannerInteger();

        executarOpção(escolha);
    }

    public void executarOpção(int escolha)
    {
        switch (escolha)
        {
            case 1 -> filmeService.mostrarFilme(dados);
            case 0 -> {
            return;
        }
        }
    }
}
