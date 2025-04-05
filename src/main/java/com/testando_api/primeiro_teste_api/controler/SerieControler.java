package com.testando_api.primeiro_teste_api.controler;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.menu.IMenu;
import com.testando_api.primeiro_teste_api.service.SerieService;
import com.testando_api.primeiro_teste_api.util.LeitorEntrada;

public class SerieControler implements ITituloControler, IMenu
{
    private SerieService serieService = new SerieService();
    private IDados dados;
    private OmdbApi omdbApi;

    public SerieControler(IDados dados, OmdbApi omdbApi)
    {
        this.dados = dados;
        this.omdbApi = omdbApi;
    }

    @Override
    public void iniciar()
    {
        System.out.println("Digite a serie");
        String serie = LeitorEntrada.returnScannerString();

        serieService.carregarDados(dados,omdbApi, serie);
        System.out.println(MENU_SERIE);

        int escolha = LeitorEntrada.returnScannerInteger();

        executarOpção(escolha);
    }

    public void executarOpção(int escolha)
    {
        switch (escolha)
        {
            case 1 -> serieService.mostrarSerie(dados);
            case 2 -> serieService.mostrarTemporada(dados);
            case 3 -> serieService.exibirEpisodiosPorAvaliacao("cresc",dados);
            case 4 -> serieService.exibirEpisodiosPorAvaliacao("desc", dados);
            case 5 -> serieService.mostrarMelhores10Episodios("desc", dados);
            case 6 -> serieService.mostrarMelhores10Episodios("cresc", dados);
            case 0 -> {
                return;
            }
        }
    }
}
