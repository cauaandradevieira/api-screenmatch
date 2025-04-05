package com.testando_api.primeiro_teste_api.api;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Setter
@Getter
public class OmdbApi
{
    private String body;
    private Integer code;

    public void criarApi(String url)
    {
        try
        {
            if (url == null || !url.startsWith("http"))
            {
                System.err.println("Erro: URL inválida deve começar com http ou https");
                System.exit(1);
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.body = response.body();
            this.code = response.statusCode();
        }

        catch (RuntimeException | IOException | InterruptedException e)
        {
            System.err.println("Erro inesperado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
