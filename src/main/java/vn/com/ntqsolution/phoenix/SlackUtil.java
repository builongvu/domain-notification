package vn.com.ntqsolution.phoenix;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class SlackUtil {

    public static void sendSlackMessage(String webhookUrl, String slackUsername, String message) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            Map<Object, Object> data = new HashMap<>();
            data.put("text", message);
            data.put("username", slackUsername);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(buildRequestBodyFromMap(data))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HttpRequest.BodyPublisher buildRequestBodyFromMap(Map<Object, Object> data) {
        StringBuilder builder = new StringBuilder("{");
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            builder.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        builder.deleteCharAt(builder.length() - 1); // Remove the trailing comma
        builder.append("}");

        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}
