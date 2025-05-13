package com.vinnisv.service;

import com.google.gson.Gson;
import com.vinnisv.http.util.HttpRequestBuilder;
import com.vinnisv.http.util.HttpResponseHandler;
import com.vinnisv.model.ExchangeRateResponse;

import java.net.http.HttpRequest;

public class ExchangeRateService {
    private final Gson gson = new Gson();

    public ExchangeRateResponse getRates(String moedaBase) {
        try {
            HttpRequest request = HttpRequestBuilder.buildRequest(moedaBase);
            String responseBody = HttpResponseHandler.sendRequest(request);

            if (responseBody == null || responseBody.isEmpty()) {
                throw new RuntimeException("Resposta da API está vazia.");
            }

            return gson.fromJson(responseBody, ExchangeRateResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter taxas de câmbio: " + e.getMessage(), e);
        }
    }
}
