import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Weather {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your city:");
        String city = scanner.nextLine();

        String url = "https://wttr.in/"
                + URLEncoder.encode(city, StandardCharsets.UTF_8)
                + "?format=%25t";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        String result = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        ).body();

        System.out.println("Temperature: " + result);
        scanner.close();
    }
}