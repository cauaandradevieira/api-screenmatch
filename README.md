# 🎬 screenmatch-api

Consumo de API REST com Java e Spring Boot para buscar e exibir informações sobre filmes e séries usando a [OMDb API](https://www.omdbapi.com/).  
Projeto com fins educacionais, criado como primeiro contato com tecnologias como Spring Boot, Lombok, Jackson e requisições HTTP.


## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Lombok
- Jackson
- OMDb API (https://www.omdbapi.com/)
- Maven

## 🧠 O que aprendi

- Criar um projeto Spring do zero
- Organização por camadas (Model, Service, Controller)
- Realizar requisições HTTP em Java puro
- Desserializar JSON com Jackson
- Manipular dados com Streams e ordenações

## 🧩 Como funciona

1. O usuário executa a aplicação no terminal.
2. A aplicação exibe um menu com opções para buscar por **filmes** ou **séries**.
3. O usuário digita o nome do título desejado.
4. É feita uma requisição GET para a OMDb API.
5. A resposta (em JSON) é convertida automaticamente em objetos Java usando Jackson.
6. As informações são exibidas no terminal:
   - Para **filmes**: exibe dados como título, ano, avaliação e data.
   - Para **séries**: além dos dados gerais, são exibidos episódios de todas as temporadas, com opções de ordenação e filtros como Top 10.
     
## 📦 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/cauaandradevieira/api-screenmatch.git
