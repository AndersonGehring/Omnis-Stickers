import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Fazer uma conexão HTTP e buscar os top 10 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();                                             //Todos esses http podem ser declarados como var
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();                       // só é feito assim para legibilidade do código
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());              //HttpClient, HttpRequest, HttpResponse<String>
        String body = response.body();

        // pegar só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados                        
        /*for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();*/

        // Avaliando os 10 filmes
        List<FilmesNota> list = new ArrayList<>();
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Qual nota você dá para este filme: " + filme.get("title"));
            double nota = sc.nextDouble();           
            FilmesNota filmeMaisNota = new FilmesNota(filme.get("title"), nota);
            list.add(filmeMaisNota);
        }
        list.forEach(System.out::println);
    sc.close();
    }
}
