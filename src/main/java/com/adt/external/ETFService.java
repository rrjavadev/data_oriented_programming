package com.adt.external;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ETFService {

    ObjectMapper objectMapper = new ObjectMapper();

    public Result fetchETF(String apiUrl) {

        try (var client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ETFResponse etfResponse = objectMapper.readValue(response.body(), ETFResponse.class);

            if (response.statusCode() == 200) {
                return new Result.Success<>(etfResponse);
            } else {
                return new Result.Failure("Error Retrieving The information with status %s".formatted(response.statusCode()));
            }

        } catch (Exception exception) {
            return new Result.Failure("Error Retrieving The information");
        }
    }
}
