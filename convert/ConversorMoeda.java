package convert;

import api.ExchangeRateApi;
import exception.ApiException;

import java.util.Map;

public class ConversorMoeda {
    private final ExchangeRateApi api = new ExchangeRateApi();

    public double converter(String de, String para, double valor) throws ApiException {
        Map<String, Double> taxas = api.getRates(de);
        Double taxa = taxas.get(para);

        if (taxa == null) {
            throw new ApiException("Moeda de destino não suportada.");
        }

        return valor * taxa;
    }
}

