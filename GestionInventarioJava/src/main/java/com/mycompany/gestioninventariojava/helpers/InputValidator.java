
package com.mycompany.gestioninventariojava.helpers;

import java.util.Scanner;

public class InputValidator {
    public static String getAlphaString(Scanner scanner, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("El valor no puede estar vacío.");
            } else if (!value.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
                System.out.println("Solo se permiten letras y espacios.");
                value = "";
            }
        } while (value.isEmpty());
        return value;
    }

    public static String getAlphaNumericString(Scanner scanner, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("El valor no puede estar vacío.");
            } else if (!value.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s.,:;¡!¿?()]+-")) {
                System.out.println("Solo se permiten letras, números y algunos signos de puntuación.");
                value = "";
            }
        } while (value.isEmpty());
        return value;
    }
    public static int getInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }

    public static double getDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }

    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("El valor no puede estar vacío.");
            }
        } while (value.isEmpty());
        return value;
    }
}
