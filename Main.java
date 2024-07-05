package com.conversormoedas.br;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    private static final String API_KEY = "185610bbc624fbabf1e4bf5d";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        String url = API_URL + fromCurrency;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double rate = conversionRates.get(toCurrency).getAsDouble();
            return amount * rate;
        } finally {
            response.close();
            httpClient.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("***********************************");
        System.out.println("Bem-Vindo(a) ao Conversor de Moedas");
        System.out.println("***********************************");

        while (continuar) {
            try {
                // Exibir as opções de moedas disponíveis
                System.out.println("Escolha a moeda de origem: ");
                System.out.println("1. USD - Dólar Americano");
                System.out.println("2. EUR - Euro");
                System.out.println("3. GBP - Libra Esterlina (Reino Unido)");
                System.out.println("4. CAD - Dólar Canadense");
                System.out.println("5. AUD - Dólar Australiano");
                System.out.println("6. JPY - Iene Japonês");
                System.out.println("7. CHF - Franco Suíço");
                System.out.println("8. CNY - Yuan Chinês");
                System.out.println("9. INR - Rúpia Indiana");
                System.out.println("10. BRL - Real Brasileiro");
                System.out.print("Digite o número da moeda de origem: ");
                int origemEscolha = scanner.nextInt();

                System.out.println("Escolha a moeda de destino: ");
                System.out.println("1. USD - Dólar Americano");
                System.out.println("2. EUR - Euro");
                System.out.println("3. GBP - Libra Esterlina (Reino Unido)");
                System.out.println("4. CAD - Dólar Canadense");
                System.out.println("5. AUD - Dólar Australiano");
                System.out.println("6. JPY - Iene Japonês");
                System.out.println("7. CHF - Franco Suíço");
                System.out.println("8. CNY - Yuan Chinês");
                System.out.println("9. INR - Rúpia Indiana");
                System.out.println("10. BRL - Real Brasileiro");
                System.out.print("Digite o número da moeda de destino: ");
                int destinoEscolha = scanner.nextInt();

                double amountUSD = 100.00;
                double amountConverted = 0.0;

                // Converter as escolhas numéricas para códigos de moeda
                String fromCurrency = getCurrencyCode(origemEscolha);
                String toCurrency = getCurrencyCode(destinoEscolha);

                // Realizar a conversão
                amountConverted = convert(fromCurrency, toCurrency, amountUSD);

                // Exibir o resultado formatado com duas casas decimais
                System.out.printf("%s %.2f = %s %.2f%n", fromCurrency, amountUSD, toCurrency, amountConverted);

                // Perguntar ao usuário se deseja continuar
                System.out.println("Deseja fazer outra conversão? (S/N)");
                String resposta = scanner.next();
                if (!resposta.equalsIgnoreCase("S")) {
                    continuar = false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
        System.out.println("Programa encerrado. Obrigado por usar o Conversor de Moedas!");
    }

    // Método auxiliar para obter o código de moeda com base na escolha do usuário
    private static String getCurrencyCode(int choice) {
        switch (choice) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "GBP";
            case 4:
                return "CAD";
            case 5:
                return "AUD";
            case 6:
                return "JPY";
            case 7:
                return "CHF";
            case 8:
                return "CNY";
            case 9:
                return "INR";
            case 10:
                return "BRL";
            default:
                throw new IllegalArgumentException("Escolha inválida de moeda.");
        }
    }
}
