package org.example;

import org.example.rooms.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Player moet de huidige status kunnen bijwerken en ophalen (Database??)
        //Player player = new Player();

        Room sprintPlanning = new RoomPlanning();
        Room dailyScrum = new RoomDaily();
        Room scrumBoard = new RoomBoard();
        Room sprintReview = new RoomReview();
        Room sprintRetrospective = new RoomRetrospective();
        Room finaleTia = new RoomTia();

        System.out.println("Naar welke kamer wil je gaan?");
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "kamer 1":
                sprintPlanning.runRoom();
                break;
            case "kamer 2":
                dailyScrum.runRoom();
                break;
            case "kamer 3":
                scrumBoard.runRoom();
                break;
            case "kamer 4":
                sprintReview.runRoom();
                break;
            case "kamer 5":
                sprintRetrospective.runRoom();
                break;
            case "kamer 6":
                finaleTia.runRoom();
                break;
            default:
                System.out.println("Onbekende kamer.");
        }
    }
}