package org.example.core.engine;


import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.rooms.Room;
import org.example.rooms.RoomFactory;
import java.util.List;

public class GameState {
    private List<Room> rooms;
    private Integer currentRoom = 0;

    public GameState(RoomFactory roomFactory) {
        this.rooms = roomFactory.createRooms();
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
}
