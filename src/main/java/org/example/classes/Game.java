package org.example.classes;

import org.example.rooms.*;
import org.example.strategies.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public void launchGame() {
        System.out.println("=========================================");
        System.out.println("  ____   ____ ____  _   _ __  __ ");
        System.out.println(" / ___| / ___|  _ \\| | | |  \\/  |");
        System.out.println(" \\___ \\| |   | |_) | | | | |\\/| |");
        System.out.println("  ___) | |___|  _ <| |_| | |  | |");
        System.out.println(" |____/ \\____|_| \\_\\\\___/|_|  |_|");
        System.out.println("                                  ");
        System.out.println("       Welkom bij het Scrumspel!");
        System.out.println("=========================================");
        System.out.println("Kies een optie:");
        System.out.println("1. Start nieuw spel");
        System.out.println("2. Huidige spel");
        System.out.println("3. Afsluiten");
        System.out.println("=========================================");

        System.out.print("Voer je keuze in (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Nieuw spel wordt gestart...");
                newGame();
                break;
            case 2:
                System.out.println("Huidig spel wordt geladen...");
                currentGame();
                break;
            case 3:
                System.out.println("Spel wordt afgesloten. Tot ziens!");
                break;
            default:
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
        }
    }

    public ArrayList<Room> Rooms() {
        MultipleChoice multipleChoice = new MultipleChoice();
        FillInTheBlank fillInTheBlank = new FillInTheBlank();
        ArrayList<Room> rooms = new ArrayList<>();

        //Kamer kan toegevoegd worden, we gebruiken de open-closed principle
        rooms.add(new RoomPlanning(multipleChoice));
        rooms.add(new RoomDaily(fillInTheBlank));
        rooms.add(new RoomBoard(multipleChoice));
        rooms.add(new RoomReview(multipleChoice));
        rooms.add(new RoomRetrospective(multipleChoice));
        rooms.add(new RoomTia(multipleChoice));

        return rooms;
    }

    public void newGame() {
        //Moet nog implementeren dat er een nieuw spel wordt aangemaakt dmv JSON
        ArrayList<Room> rooms = Rooms();

        System.out.println("=========================================");
        System.out.println("Kies een kamer om mee te beginnen! (bijv. kamer 1):");
        String input = scanner.nextLine().toLowerCase();

        if (input.startsWith("kamer")) {
            try {
                int roomNumber = Integer.parseInt(input.replace("kamer", "").trim());
                if (roomNumber >= 1 && roomNumber <= rooms.size()) {
                    rooms.get(roomNumber - 1).runRoom();
                } else {
                    System.out.println("Kamer bestaat niet.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer voor kamer.");
            }
        } else {
            System.out.println("Onbekende invoer.");
        }
    }

    public void currentGame() {
        //Casper neemt dit over ivm opslaan van currentGame
        Player player = new Player();
        player.getCurrentRoom();
    }
}