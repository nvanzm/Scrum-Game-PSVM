package org.example.core.engine;

import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;
import java.util.List;

public class GameState {
    private final List<Room> rooms;
    private int currentRoom = 0;
    private final IGameCloser gameCloser;

    public GameState(IRoomFactory roomFactory, IGameCloser gameCloser) {
        this.rooms = roomFactory.createRooms();
        this.gameCloser = gameCloser;
    }

    public void advanceRoom() {
        if (currentRoom == rooms.size() - 1) {
            completedGame();
        } else {
            currentRoom++;
        }
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoom);
    }

    public Menu getMainMenu() {
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
    }

    public void completedGame() {
        System.out.println("Congrats! You've successfully completed the quiz!");
        closeGame();
    }

    public void closeGame() {
        gameCloser.close();
    }
}
