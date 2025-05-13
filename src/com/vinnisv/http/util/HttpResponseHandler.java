package com.vinnisv.http.util;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpResponseHandler {
    public static String sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpClient client = HttpClientService.getClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Se for diferente de 200, ira aparecer mensagem de erro! "Estudar mais sobre StatusCode"
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: Status code " + response.statusCode());
        }

        return response.body();
    }
}
