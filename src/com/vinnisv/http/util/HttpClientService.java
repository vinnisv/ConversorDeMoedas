package com.vinnisv.http.util;

import java.net.http.HttpClient;

public class HttpClientService {
    private static final HttpClient client = HttpClient.newHttpClient();

    private HttpClientService() {
        throw new IllegalStateException("Esta classe não pode ser instanciada. Use os métodos estáticos diretamente.");
    }

    public static HttpClient getClient(){
        return client;
    }
}
