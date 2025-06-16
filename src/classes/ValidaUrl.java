
package src.classes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ValidaUrl {

    public String valida(String city, String ddd) {
        String apikey = System.getenv("OPEN_WEATHER_API");

        try {

            String cidadeCodificada = URLEncoder.encode(city, StandardCharsets.UTF_8);

            return "https://api.openweathermap.org/data/2.5/weather?q="
                    + cidadeCodificada + "," + ddd + ",BR&appid=" + apikey
                    + "&units=metric&lang=pt_br";
        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir URL para a cidades: " + city, e);
        }
    }
}