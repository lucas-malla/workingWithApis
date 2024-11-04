import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmConsultation {
        public Movie filmsearch(int numberOfMovie){
            URI direction = URI.create("https://swapi.dev/api/films/"+numberOfMovie);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direction)
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Movie.class);
            } catch (Exception e) {
                throw new RuntimeException("No Movie Found.");
            }
        }
    }

