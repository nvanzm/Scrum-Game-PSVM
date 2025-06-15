package org.example.core.engine;


import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.questions.QuestionBehavior;
import org.example.questions.strategies.FillInTheBlank;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.questions.strategies.Puzzle;
import org.example.rooms.Room;
import org.example.rooms.templates.*;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<Room> rooms;
    private Integer currentRoom = 0;

    public GameState() {
        rooms = new ArrayList<>();
    }

    public void setupRooms() {
        IOHandler ioHandler = new ConsoleIOHandler();

        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler);
        QuestionBehavior fillInTheBlank = new FillInTheBlank();

        Room roomPlanning = new RoomPlanning(multipleChoiceBehavior,"Planning Room", "Welcome to the Planning Room! Let's prepare for the next sprint.");
        Room roomDaily = new RoomDaily(fillInTheBlank,"Daily Standup Room", "Welcome to the Daily Room! Time for your daily check-in.");
        Room roomBoard = new RoomBoard(multipleChoiceBehavior, "Board Room", "This is the board room.");
        Room roomReview = new RoomReview(fillInTheBlank,"Review Room", "Welcome to the Review Room! Let's review what we've accomplished.");
        Room roomRetro = new RoomRetrospective(multipleChoiceBehavior,"Retrospective Room", "Welcome to the Retrospective Room! Let's reflect and improve.");
        Room roomTia = new RoomTia(multipleChoiceBehavior, "Tia's Room", "Welcome to Tia's room! Here you'll answer questions about Scrum.");

        // Add all room to rooms collection
        this.addRoom(roomPlanning);
        this.addRoom(roomDaily);
        this.addRoom(roomBoard);
        this.addRoom(roomReview);
        this.addRoom(roomRetro);
        this.addRoom(roomTia);
    }

    public void advanceRoom() {
//        System.out.println(rooms);
        if (currentRoom == rooms.size() - 1) {
            return;
        }

        currentRoom++;
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public Menu getMainMenu() {
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize() {

    }
}
