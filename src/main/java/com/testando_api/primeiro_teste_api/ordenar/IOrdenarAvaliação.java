package com.testando_api.primeiro_teste_api.ordenar;

import com.testando_api.primeiro_teste_api.dado.IDados;

public interface IOrdenarAvaliação <T>
{
    void ordenarPorAvaliação(T titulo, IDados dados,String ordem);
    default void ordenarPorAvaliaçãoTop10(T titulo, IDados dados, String ordem){}

}
