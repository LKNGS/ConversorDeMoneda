import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class usoDeAPI {
    private static final String API_KEY = "cfdc0e963417b1cdfa7879d8";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaCambio(String base, String destino) throws Exception {
        String url = API_URL + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        respuestaTipoCambio data = gson.fromJson(response.body(), respuestaTipoCambio.class);

        if (!"success".equals(data.result())) {
            throw new RuntimeException("API no respondió con éxito.");
        }

        Double tasa = data.conversion_rates().get(destino);
        if (tasa == null) {
            throw new IllegalArgumentException("No se encontró la moneda destino.");
        }

        return tasa;
    }
}
