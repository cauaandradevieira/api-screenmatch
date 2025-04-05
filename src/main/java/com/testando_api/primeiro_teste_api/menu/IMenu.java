package com.testando_api.primeiro_teste_api.menu;

public interface IMenu
{
    String MENU_TITULOS = "[1]- serie\n[2]- filme\n[0]- sair";

    String MENU_FILME = "[1] - Ver informações de filme\n" + "[0]- sair";

    String MENU_SERIE =  "[1] - ver informações de Serie\n" +
            "[2] - ver informações de todos episodios\n" +
            "[3] - ver informações de episodios ordenado por avalição ( crescente )\n" +
            "[4] - ver informações de episodios ordenado por avaliação ( decrescente )\n" +
            "[5] - ver informações dos melhores 10 episodios\n" +
            "[6] - ver informações dos piores 10 episodios\n"+
            "[0]- sair";

}
