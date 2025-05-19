package ui;

import convert.ConversorMoeda;
import exception.ApiException;
import coin.Moeda;
import useful.Leitor;

import java.util.Scanner;

public class Menu {
    private final ConversorMoeda conversor = new ConversorMoeda();
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.out.println("===== CONVERSOR DE MOEDAS =====");
            System.out.println("1. Dólar para Real");
            System.out.println("2. Real para Dólar");
            System.out.println("3. Dólar para Peso Argentino");
            System.out.println("4. Peso Argentino para Dólar");
            System.out.println("5. Dólar para Peso Colombiano");
            System.out.println("6. Peso Colombiano para Dólar");
            System.out.println("7. Sair");
            System.out.println("===== CONVERSOR DE MOEDAS =====\n");
            System.out.print("Escolha uma opção: ");
            int opcao = Leitor.lerInt(scanner);

            try {
                if (opcao == 7) {
                    System.out.println("Saída com sucesso!");
                    break;
                }
                else if (opcao < 1 || opcao > 7) {
                    System.out.println(("Incorreta! Digite uma opção válida."));
                    continue;
                }

                System.out.print("Digite o valor a converter: ");
                double valor = Leitor.lerDouble(scanner);
                double resultado = 0;

                switch (opcao) {
                    case 1:
                        resultado = conversor.converter("USD", "BRL", valor);
                        break;
                    case 2:
                        resultado = conversor.converter("BRL", "USD", valor);
                        break;
                    case 3:
                        resultado = conversor.converter("USD", "ARS", valor);
                        break;
                    case 4:
                        resultado = conversor.converter("ARS", "USD", valor);
                        break;
                    case 5:
                        resultado = conversor.converter("USD", "COP", valor);
                        break;
                    case 6:
                        resultado = conversor.converter("COP", "USD", valor);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                System.out.printf("O valor de %.2f corresponde ao valor convertido de %.2f\n", valor, resultado);

            } catch (ApiException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
