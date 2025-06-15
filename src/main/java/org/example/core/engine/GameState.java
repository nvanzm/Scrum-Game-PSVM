package org.example.core.engine;

import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;
import java.util.List;

public class GameState {
    private List<Room> rooms;
    private Integer currentRoom = 0;

    public GameState(IRoomFactory roomFactory) {
        this.rooms = roomFactory.createRooms();
    }

    public void advanceRoom() {
        if (currentRoom == rooms.size() - 1) {
            completedGame();
        }

        currentRoom++;
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public Menu getMainMenu() {
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
    }

    public void completedGame() {
        System.out.println("Congrats! You've succesfully completed the quiz!");
        closeGame();
    }

    public void closeGame() {
        System.exit(0);
    }
}