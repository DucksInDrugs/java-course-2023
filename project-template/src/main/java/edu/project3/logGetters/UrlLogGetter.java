package edu.project3.logGetters;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UrlLogGetter implements LogGetter {
    private final String path;

    public UrlLogGetter(String path) {
        this.path = path;
    }

    @Override
    public List<String> getRecords() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(path))
                .GET()
                .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().lines().toList();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getNames() {
        return List.of(path.substring(path.lastIndexOf("/")));
    }
}
