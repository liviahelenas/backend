package modelos;

import com.google.gson.Gson;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTemperatura {

    /*colocar o link da API*/

    public Temperatura consultaTemperatura(String cidade) throws IOException, InterruptedException {


        String cidadeCodificada = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        URI endereco = URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + cidadeCodificada +
                "&appid=ed827368b09c96f2c0cdf8bbb6800134&units=metric&lang=pt_br");

        //faça a requisicao. 1)httpClient 2)httpRequest 3)httpResponse

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(endereco)))
                .build();

        /*trabalhando com excessoes:*/

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter os dados da modelos.Temperatura!");

        }

        /* chamando o Gson e linkando com as informações no record */

        return new Gson().fromJson(response.body(), Temperatura.class);


    }

}