package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("\nEntrez le premier nombre (ou 'q' pour quitter) : ");
            String inputA = scanner.next();
            if (inputA.equalsIgnoreCase("q")) break;

            double a;
            try {
                a = Double.parseDouble(inputA);
            } catch (NumberFormatException e) {
                System.out.println("Ceci n'est pas un nombre, mais une tentative artistique.");
                continue;
            }

            System.out.print("Entrez l'opération (+, -, *, /) : ");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("q")) break;

            System.out.print("Entrez le deuxième nombre (ou 'q' pour quitter) : ");
            String inputB = scanner.next();
            if (inputB.equalsIgnoreCase("q")) break;

            double b;
            try {
                b = Double.parseDouble(inputB);
            } catch (NumberFormatException e) {
                System.out.println("C'est pas un nombre!");
                continue;
            }

            try {
                double result;
                switch (operation) {
                    case "+":
                        result = calculator.add(a, b);
                        break;
                    case "-":
                        result = calculator.subtract(a, b);
                        break;
                    case "*":
                        result = calculator.multiply(a, b);
                        break;
                    case "/":
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("Opération inconnue ! Essayez +, -, * ou /");
                        continue;
                }
                System.out.println("Résultat : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        
        System.out.println("Programme STOP");
        scanner.close();
    }
}
