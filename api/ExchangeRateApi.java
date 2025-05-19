package api;

import com.google.gson.Gson;
import exception.ApiException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ExchangeRateApi {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2c3b205502d0f79145c16719/latest/";

    public Map<String, Double> getRates(String baseCurrency) throws ApiException {
        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new ApiException("Erro ao conectar à API ExchangeRate.");
            }

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            ApiResponse response = gson.fromJson(reader, ApiResponse.class);

            return response.conversion_rates;
        } catch (Exception e) {
            throw new ApiException("Erro ao obter taxas de câmbio: " + e.getMessage());
        }
    }

    private class ApiResponse {
        Map<String, Double> conversion_rates;
    }
}
