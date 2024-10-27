package principalComListas;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PricipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entra = new Scanner(System.in);

        System.out.println("Escreva o nome do filme: ");

        String filme = entra.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t=" + filme + "&apikey=9dd96919"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb meuTitulo = gson.fromJson(json, TituloOmdb.class);

        System.out.println("Título: " + meuTitulo.Title());
        System.out.println("Ano de Lançamento: " + meuTitulo.Year());
        System.out.println("runtime: " + meuTitulo.runtime());
    }
}