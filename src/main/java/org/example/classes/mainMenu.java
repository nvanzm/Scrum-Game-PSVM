package org.example.classes;

import java.util.Scanner;

public class mainMenu extends Menu {
    Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void begroeting() {
        System.out.println("=========================================");
        System.out.println("  ____   ____ ____  _   _ __  __ ");
        System.out.println(" / ___| / ___|  _ \\| | | |  \\/  |");
        System.out.println(" \\___ \\| |   | |_) | | | | |\\/| |");
        System.out.println("  ___) | |___|  _ <| |_| | |  | |");
        System.out.println(" |____/ \\____|_| \\_\\\\___/|_|  |_|");
        System.out.println("                                  ");
        System.out.println("       Welkom bij het Scrumspel!");
        System.out.println("=========================================");
    }

    @Override
    public void optieMenu() {
        Scanner scanner = new Scanner(System.in);

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
                System.out.println("Type 'Pauze' als je terug wilt gaan naar het menu!");
                game.newGame();
                break;
            case 2:
                System.out.println("Huidig spel wordt geladen...");
                System.out.println("Type 'Pauze' als je terug wilt gaan naar het menu!");
                game.currentGame();
                break;
            case 3:
                System.out.println("Spel wordt afgesloten. Tot ziens!");
                break;
            default:
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
        }
    }
}