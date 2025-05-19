package useful;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Leitor {
    public static int lerInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                scanner.nextLine();
            }
        }
    }

    public static double lerDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um número válido: ");
                scanner.nextLine();
            }
        }
    }
}
