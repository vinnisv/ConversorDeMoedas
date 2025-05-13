package com.vinnisv;

import com.vinnisv.model.ExchangeRateResponse;
import com.vinnisv.service.ExchangeRateService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService service = new ExchangeRateService();

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("******************************************");
            System.out.println("SEJA BEM VINDO AO CONVERSOR DE MOEDAS\n");
            System.out.println("1) DÓLAR -> PESO ARGENTINO");
            System.out.println("2) PESO ARGENTINO -> DÓLAR");
            System.out.println("3) DÓLAR -> REAL BRASILEIRO");
            System.out.println("4) REAL BRASILEIRO -> DÓLAR");
            System.out.println("5) DÓLAR -> EURO");
            System.out.println("6) EURO -> DÓLAR");
            System.out.println("7) SAIR.");
            System.out.println("ESCOLHA UMA OPÇÃO VÁLIDA: ");
            System.out.println("******************************************");

            opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Obrigado por utilizar o conversor. Espero que tenha ajudado, até mais!");
                break;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            String base = "", destino = "";

            switch (opcao) {
                case 1 -> { base = "USD"; destino = "ARS"; }
                case 2 -> { base = "ARS"; destino = "USD"; }
                case 3 -> { base = "USD"; destino = "BRL"; }
                case 4 -> { base = "BRL"; destino = "USD"; }
                case 5 -> { base = "USD"; destino = "EUR"; }
                case 6 -> { base = "EUR"; destino = "USD"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            try {
                ExchangeRateResponse response = service.getRates(base);
                double taxa = response.conversion_rates().get(destino);
                double convertido = valor * taxa;

                System.out.printf("Valor convertido de %s para %s: %.2f%n", base, destino, convertido);
            } catch (Exception e) {
                System.out.println("Erro ao realizar conversão: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}