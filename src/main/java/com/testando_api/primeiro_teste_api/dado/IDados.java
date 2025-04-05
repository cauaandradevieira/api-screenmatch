package com.testando_api.primeiro_teste_api.dado;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface IDados
{
    <T> T receberDadosDo(Class <T> classeAtual, String json);
    <T> void mostrarJsonDo(T titulo);
    default <T> String retornarJson(T titulo, ObjectMapper objectMapper)
    {
        try
        {
            return objectMapper.writeValueAsString(titulo);

        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException("ERRO NA CLASSE IDADOS " + e.getMessage(), e);
        }
    }

}
