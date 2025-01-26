package com.example.inputsanitizer;

import java.util.Scanner;

public class InputSanitizer {

    public static String sanitizeInput(String input) {
        if (input == null || input.isEmpty()) {
            return "Input is null or empty.";
        }

        char[] harmfulChars = {'<', '>', '\'', '\"'};
        boolean sanitized = false;
        StringBuilder sanitizedInput = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            boolean isHarmful = false;
            for (char harmful : harmfulChars) {
                if (currentChar == harmful) {
                    isHarmful = true;
                    sanitized = true;
                    break;
                }
            }
            if (isHarmful) {
                sanitizedInput.append('_');
            } else {
                sanitizedInput.append(currentChar);
            }
        }

        if (sanitized) {
            return "Your input was sanitized. Sanitized input: " + sanitizedInput.toString();
        } else {
            return "Your input is safe: " + sanitizedInput.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input: ");
        String userInput = scanner.nextLine();
        String result = sanitizeInput(userInput);
        System.out.println(result);
        scanner.close();
    }
}
