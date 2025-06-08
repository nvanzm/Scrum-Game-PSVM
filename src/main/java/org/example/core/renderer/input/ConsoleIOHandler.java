package org.example.core.renderer.input;

import org.example.core.renderer.IOHandler;

import java.util.List;
import java.util.Scanner;

public class ConsoleIOHandler implements IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayOptions(List<String> options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public int getNumericInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int number = Integer.parseInt(input);
                if (number > 0) {  // Assuming we want positive numbers
                    return number;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    @Override
    public String getTextInput() {
        return scanner.nextLine().trim();
    }
}