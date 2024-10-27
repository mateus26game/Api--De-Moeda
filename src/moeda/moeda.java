package moeda;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class moeda {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(" https://v6.exchangerate-api.com/v6/6ba85587fed44ebaf0949cd5/latest/USD"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println("JSON Response: " + json); // Imprime a resposta JSON para depuração

        Gson gson = new Gson();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(json, ExchangeRateResponse.class);

        if (exchangeRateResponse != null && exchangeRateResponse.getRates() != null) {
            double usdToBrl = exchangeRateResponse.getRates().getBRL();
            System.out.println("1 USD = " + usdToBrl + " BRL");
        } else {
            System.out.println("Rates object is null or ExchangeRateResponse is null");
        }
    }
}

class ExchangeRateResponse {
    private Rates rates;

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}

class Rates {
    @SerializedName("BRL")
    private double brl;

    public double getBRL() {
        return brl;
    }

    public void setBRL(double brl) {
        this.brl = brl;
    }
}
