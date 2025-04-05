package com.testando_api.primeiro_teste_api.dado;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DadosJson implements IDados
{
    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public <T> T receberDadosDo(Class<T> classeAtual, String json)
    {
        try
        {
            return objectMapper.readValue(json, classeAtual);
        }
        catch (JsonProcessingException e)
        {
            System.err.println("Erro ao desserializar JSON: " + e.getMessage());
            System.err.println("JSON recebido: " + json);
            throw new RuntimeException("Erro ao processar dados JSON na classe Dados");
        }
    }

    @Override
    public <T> void mostrarJsonDo(T classe)
    {
        System.out.println(retornarJson(classe,objectMapper));
    }
}
