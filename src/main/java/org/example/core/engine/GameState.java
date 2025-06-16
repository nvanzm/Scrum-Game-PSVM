package org.example.core.engine;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.player.Player;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.JsonHandler;
import org.example.core.renderer.SaveHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.menus.MainMenu;
import org.example.menus.Menu;
import org.example.questions.QuestionBehavior;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.menus.Menu;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;
import java.util.List;

public class GameState {

    private final List<Room> rooms;
    private int currentRoom = 0;
    private final IGameCloser gameCloser;
    private final IGameUI gameUI;

    public GameState(IRoomFactory roomFactory, IGameCloser gameCloser, IGameUI gameUI) {
        this.rooms = roomFactory.createRooms();
        this.gameCloser = gameCloser;
        this.gameUI = gameUI;
    }

    public void advanceRoom() {
        if (currentRoom == rooms.size() - 1) {
            completedGame();
        } else {
            currentRoom++;
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