package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    public long[] hackerNewsTopStories() {
        String responseBody = getResponseBody("/topstories.json");
        return parseTopStories(responseBody);
    }

    public String news(long id) {
        String responseBody = getResponseBody("item/" + id + ".json");
        Pattern pattern = Pattern.compile("\"title\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

    private static String getResponseBody(String input) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/" + input))
                .GET()
                .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] parseTopStories(String response) {
        var stringIds = response.substring(1, response.length() - 1).split(",");

        return Arrays.stream(stringIds).mapToLong(Long::parseLong).toArray();
    }
}
