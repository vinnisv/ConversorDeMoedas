package com.vinnisv.http.util;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestBuilder {
    private static final String API_KEY = "b7b928824887200dc1061225";


    public static HttpRequest buildRequest(String moedaBase) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaBase;

        System.out.println("Conversao sendo realizada. ");

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
