package com.testando_api.primeiro_teste_api.controler;

import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.api.UrlApi;
import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.dado.DadosJson;
import com.testando_api.primeiro_teste_api.menu.IMenu;
import com.testando_api.primeiro_teste_api.util.LeitorEntrada;

public class TituloControler implements UrlApi, IMenu
{
    private OmdbApi omdbApi = new OmdbApi();
    private IDados dados = new DadosJson();
    private ITituloControler titulo;

    public void iniciar()
    {
        while (true)
        {
            try
            {
                int escolha = menuEOpcao();

                executarOpcao(escolha);

                titulo.iniciar();
            }
            catch (NumberFormatException e)
            {
                System.err.println("Erro: entrada inválida");
            }
            catch (RuntimeException e)
            {
                System.err.println(e.getMessage());
            }
        }
    }

    public void executarOpcao(int escolha)
    {
        switch (escolha)
        {
            case 1 -> titulo = new SerieControler(dados,omdbApi);
            case 2 -> titulo = new FilmeControler(dados,omdbApi);
            case 0 -> finalizarPrograma();
            default ->
            {
                throw new IllegalArgumentException("Erro: codigo invalido");
            }
        }
    }

    public int menuEOpcao()
    {
        System.out.println(MENU_TITULOS);
        return LeitorEntrada.returnScannerInteger();
    }

    public void finalizarPrograma()
    {
        LeitorEntrada.liberarScanner();
        System.exit(0);
    }
}
