package com.testando_api.primeiro_teste_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.testando_api.primeiro_teste_api.api.OmdbApi;
import com.testando_api.primeiro_teste_api.model.SerieModel;
import com.testando_api.primeiro_teste_api.model.TemporadaModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class PrimeiroTesteApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroTesteApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
        ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		OmdbApi omdbApi = new OmdbApi();
        omdbApi.createApi();
        String body = omdbApi.returnBody();

        TemporadaModel temporadaModel = objectMapper.readValue(body, TemporadaModel.class);
        System.out.println(temporadaModel);

        String json = objectMapper.writeValueAsString(temporadaModel);
        System.out.println(json);
        //objectMapper.writeValue(new File("arquivo.json"), serieModel);


	}
}
