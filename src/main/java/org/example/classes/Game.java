package org.example.classes;

import org.example.interfaces.QuestionBehavior;
import org.example.rooms.*;
import org.example.strategies.*;
import java.util.ArrayList;

public class Game {
    private final Menu mainMenu;
    private final Menu chooseRoom;

    public Game(Menu homeScherm, Menu chooseRoom) {
        this.mainMenu = homeScherm;
        this.chooseRoom = chooseRoom;

        if (homeScherm instanceof org.example.classes.MainMenu mainMenu) {
            mainMenu.setGame(this);
        }
    }

    public void launchGameAndPauseGame() {
        mainMenu.display();
    }

    public void newGame() {
        //Moet nog implementeren dat er een nieuw spel wordt aangemaakt dmv JSON
        chooseRoom.display();
    }

    public void currentGame() {
        //Casper neemt dit over ivm opslaan van currentGame
//        Player player = new Player();
//        player.getCurrentRoom();
    }

    public ArrayList<Room> Rooms() {
        QuestionBehavior multipleChoice = new MultipleChoice();
        QuestionBehavior fillInTheBlank = new FillInTheBlank();
        QuestionBehavior puzzle = new Puzzle();
        ArrayList<Room> rooms = new ArrayList<>();

        //Kamer kan toegevoegd worden, we gebruiken de open-closed principle
        rooms.add(new RoomReview(puzzle));
        rooms.add(new RoomPlanning(multipleChoice));
        rooms.add(new RoomDaily(fillInTheBlank));
        rooms.add(new RoomBoard(multipleChoice));
        rooms.add(new RoomRetrospective(multipleChoice));
        rooms.add(new RoomTia(multipleChoice));

        return rooms;
    }
}