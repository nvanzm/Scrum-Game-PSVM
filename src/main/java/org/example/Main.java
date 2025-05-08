package org.example;

import org.example.rooms.RoomPlanning;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomPlanning sprintPlanning = new RoomPlanning();

        System.out.println("Naar welke kamer wil je gaan?");
        String input = scanner.nextLine();

        switch (input) {
            case "Kamer 1":
                sprintPlanning.handleQuestion();
                break;
            default:
                System.out.println("Onbekende kamer.");
        }
    }
}