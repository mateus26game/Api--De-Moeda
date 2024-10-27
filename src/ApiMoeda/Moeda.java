package ApiMoeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Moeda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/6ba85587fed44ebaf0949cd5/latest/USD"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse do JSON de resposta
            String json = response.body();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            // Criação de um objeto TiposMoedas para armazenar as taxas de câmbio
            TiposMoedas tiposMoedas = new TiposMoedas();
            tiposMoedas.setUSD(rates.get("USD").getAsDouble());
            tiposMoedas.setBRL(rates.get("BRL").getAsDouble());
            tiposMoedas.setPHP(rates.get("PHP").getAsDouble());

            // Exibir as taxas de câmbio atuais
            System.out.println("----------------------------------------------------------");
            System.out.println("Essas são as taxas de câmbio atuais:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("USD: %.2f\n", tiposMoedas.getUSD());
            System.out.printf("BRL: %.2f\n", tiposMoedas.getBRL());
            System.out.printf("PHP: %.2f\n", tiposMoedas.getPHP());
            System.out.println("----------------------------------------------------------");
            // Perguntar ao usuário qual operação deseja realizar
            System.out.println("Escolha uma opção de conversão:");
            System.out.println("1 - Converter de BRL para outra moeda");
            System.out.println("2 - Converter de USD para outra moeda");
            System.out.println("3 - Converter de PHP para outra moeda");
            System.out.println("----------------------------------------------------------");
            int opcao = scanner.nextInt();
            System.out.println("----------------------------------------------------------");
            // Perguntar o valor a ser convertido
            System.out.print("Digite o valor a ser convertido: ");
            double valorOrigem = scanner.nextDouble();

            double taxaConversao = 0;
            switch (opcao) {
                case 1:
                    System.out.println("Escolha a moeda de destino:");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("1 - BRL para USD");
                    System.out.println("2 - BRL para PHP");
                    System.out.println("----------------------------------------------------------");
                    int destinoBRL = scanner.nextInt();

                    if (destinoBRL == 1) {

                        taxaConversao = tiposMoedas.getUSD() / tiposMoedas.getBRL();
                        System.out.println("----------------------------------------------------------");
                    } else if (destinoBRL == 2) {

                        taxaConversao = tiposMoedas.getPHP() / tiposMoedas.getBRL();
                        System.out.println("----------------------------------------------------------");
                    } else {
                        System.out.println("Opção inválida.");
                        return;
                    }
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Escolha a moeda de destino:");
                    System.out.println("1 - USD para BRL");
                    System.out.println("2 - USD para PHP");
                    System.out.println("----------------------------------------------------------");
                    int destinoUSD = scanner.nextInt();

                    if (destinoUSD == 1) {

                        taxaConversao = tiposMoedas.getBRL() / tiposMoedas.getUSD();
                        System.out.println("----------------------------------------------------------");
                    } else if (destinoUSD == 2) {

                        taxaConversao = tiposMoedas.getPHP() / tiposMoedas.getUSD();
                        System.out.println("----------------------------------------------------------");
                    } else {
                        System.out.println("Opção inválida.");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Escolha a moeda de destino:");
                    System.out.println("1 - PHP para BRL");
                    System.out.println("2 - PHP para USD");
                    System.out.println("----------------------------------------------------------");
                    int destinoPHP = scanner.nextInt();

                    if (destinoPHP == 1) {

                        taxaConversao = tiposMoedas.getBRL() / tiposMoedas.getPHP();
                        System.out.println("----------------------------------------------------------");
                    } else if (destinoPHP == 2) {

                        taxaConversao = tiposMoedas.getUSD() / tiposMoedas.getPHP();
                        System.out.println("----------------------------------------------------------");
                    } else {
                        System.out.println("Opção inválida.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Opção de origem inválida.");
                    return;
            }

            // Calcula o valor convertido e exibe o resultado
            double valorConvertido = valorOrigem * taxaConversao;
            System.out.printf("O valor convertido é: %.2f\n", valorConvertido);

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao fazer a requisição: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
