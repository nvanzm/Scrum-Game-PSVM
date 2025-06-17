package org.example.core.engine;

import org.example.core.player.Player;
import org.example.menus.Menu;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;

import java.util.List;

public class GameState {

    private final List<Room> rooms;
    private final IGameCloser gameCloser;
    private final IGameUI gameUI;
    private Player player = new Player();

    public GameState(IRoomFactory roomFactory, IGameCloser gameCloser, IGameUI gameUI) {
        this.rooms = roomFactory.createRooms();
        this.gameCloser = gameCloser;
        this.gameUI = gameUI;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void advanceRoom() {
        if (player.getCurrentRoom() == rooms.size() - 1) {
            completedGame();
        } else {
            player.setCurrentRoom(player.getCurrentRoom() + 1);
        }
    }

    public Room getCurrentRoom() {
        return rooms.get(player.getCurrentRoom());
    }

    public Menu getMainMenu() {
        return gameUI.createMainMenu();
    }

    public void completedGame() {
        gameUI.showCompletionMessage();
        closeGame();
    }

    public void closeGame() {
        gameCloser.close();
    }

}