package org.example.core.engine;


import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.questions.QuestionBehavior;
import org.example.questions.strategies.FillInTheBlank;
import org.example.questions.strategies.MultipleChoice;
import org.example.questions.strategies.Puzzle;
import org.example.rooms.Room;
import org.example.rooms.templates.*;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    List<Room> rooms;
    Integer currentRoom = 0;

    public GameState() {
        rooms = new ArrayList<>();
    }

    public void setupRooms() {
        QuestionBehavior multipleChoice = new MultipleChoice();
        QuestionBehavior fillInTheBlank = new FillInTheBlank();
        QuestionBehavior puzzle = new Puzzle();

        //Kamer kan toegevoegd worden, we gebruiken de open-closed principle
        rooms.add(new RoomTia(multipleChoice, "TIA Kamer", "Hallo daar!"));
        rooms.add(new RoomReview(puzzle, "Review Kamer", "Hallo daar!"));
        rooms.add(new RoomPlanning(multipleChoice, "Planning Kamer", "Hallo daar!"));
        rooms.add(new RoomDaily(fillInTheBlank, "Daily Kamer", "Hallo daar!"));
        rooms.add(new RoomBoard(multipleChoice, "Board Kamer", "Hallo daar!"));
        rooms.add(new RoomRetrospective(multipleChoice, "Retrospective Kamer", "Hallo daar!"));
    }

    public void advanceRoom() {
        if (currentRoom == rooms.size() - 1) {
            return;
        }

        currentRoom++;
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public Menu getMainMenu() {
        return new MainMenu("Main Menu", "Welcome to the main menu!");
    }

}
