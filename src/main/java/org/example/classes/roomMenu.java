package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class roomMenu extends Menu {
    Menu homeScherm;
    Menu chooseRoom;

    Player player = new Player();
//    int currentRoom = player.currentRoom;
    //Test currentRoom op 2
    int currentRoom = 2;

    @Override
    public void begroeting() {
        System.out.println("=========================================");
        System.out.println("Kies een kamer om mee te beginnen! (bijv. kamer 1):");
    }

    @Override
    public void optieMenu() {
        Game game = new Game(homeScherm, chooseRoom);
        ArrayList<Room> rooms = game.Rooms();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("kamer")) {
                try {
                    int roomNumber = Integer.parseInt(input.replace("kamer", "").trim());
                    if (currentRoom >= roomNumber) {
                        if (roomNumber >= 1 && roomNumber <= rooms.size()) {
                            rooms.get(roomNumber - 1).runRoom();
                            break;
                        } else {
                            System.out.println("Kamer bestaat niet, probeer het opnieuw!");
                        }
                    } else {
                        System.out.println("Je hebt deze kamer nog niet vrij gespeeld, probeer eerst de kamer(s) hiervoor te behalen!");
                        System.out.println("Kies een kamer om mee te beginnen! (bijv. kamer 1):");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ongeldige invoer voor kamer, probeer het opnieuw!");
                }
                // Pauze optie gecommentarieerd, nog niet werkend ivm mainMenu null
                // } else if (input.equals("pauze")) {
                //     game.launchGameAndPauseGame();
            } else {
                System.out.println("Onbekende invoer, probeer het opnieuw!");
            }
        }
    }
}