package src.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscaCidade {

    public String cidade(String city, String ddd) throws IOException, InterruptedException {
        String apikey = System.getenv("OPEN_WEATHER_API");
        HttpClient client =  HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q="
                        + URLEncoder.encode(city, StandardCharsets.UTF_8)
                        +","+ddd+",+55&appid="+apikey+"&units=metric&lang=pt_br&mode=json"))
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
