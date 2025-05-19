package org.example;
import org.example.classes.Room;
import org.example.rooms.*;
import org.example.strategies.*;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultipleChoice multipleChoice = new MultipleChoice();
        FillInTheBlank fillInTheBlank = new FillInTheBlank();
        Room sprintPlanning = new RoomPlanning(multipleChoice);
        Room dailyScrum = new RoomDaily(fillInTheBlank);
        Room scrumBoard = new RoomBoard(multipleChoice);
        Room sprintReview = new RoomReview(multipleChoice);
        Room sprintRetrospective = new RoomRetrospective(multipleChoice);
        Room finaleTia = new RoomTia(multipleChoice);

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