package com.testando_api.primeiro_teste_api.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbApi implements IOmdbApi
{
    private HttpResponse<String> httpResponse;

    public void createApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiPath+apiKey))
                .GET()
                .build();
        this.httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public String returnBody()
    {
        return httpResponse.body();
    }

    public int returnStatusCode()
    {
        return httpResponse.statusCode();
    }
}
