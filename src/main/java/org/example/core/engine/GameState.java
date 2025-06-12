package org.example.core.engine;


import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.questions.QuestionBehavior;
import org.example.questions.strategies.MultipleChoiceBehavior;
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
        IOHandler ioHandler = new ConsoleIOHandler();

        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler);

        Room roomTia = new RoomTia(
                multipleChoiceBehavior,
                "Tia's Room",
                "Welcome to Tia's room! Here you'll answer questions about Scrum."
        );

        // Add room to your rooms collection
        rooms.add(roomTia);
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
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize(){

    }
}
