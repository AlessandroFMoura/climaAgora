package src.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCidade {


    public String cidades(String city, String ddd)  throws IOException, InterruptedException {

        ValidaUrl cidade = new ValidaUrl();
        String url = cidade.valida(city, ddd);

        HttpClient client =  HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        Clima clima = gson.fromJson(response.body(), Clima.class);

        String temperatua = """
                ==============================
                Em %s hoje teremos:
                ==============================
                Temperatura Atual: %.2f°
                Tempratura Máxima: %.2f°
                Tempratura Mínima: %.2f°
                """;

        return String.format(temperatua,
                clima.name(),
                clima.main().temp(),
                clima.main().temp_max(),
                clima.main().temp_min());
    }

}
