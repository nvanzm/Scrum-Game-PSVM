package org.example.core.engine;

import org.example.rooms.IRoomFactory;
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

import org.example.rooms.Room;
import java.util.List;

public class GameState {


    private final List<Room> rooms;
    private int currentRoom = 0;
    private final IGameCloser gameCloser;
    private final IGameUI gameUI;
    Player player;
    SaveHandler saveHandler;
    private static final Logger LOGGER = LogManager.getLogger();


    public GameState(IRoomFactory roomFactory, IGameCloser gameCloser, IGameUI gameUI) {
        this.rooms = roomFactory.createRooms();
        this.gameCloser = gameCloser;
        this.gameUI = gameUI;
    }

    public void setupRooms() {
        IOHandler ioHandler = new ConsoleIOHandler();

        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler);

        Room roomTia = new RoomTia(multipleChoiceBehavior, "Tia's Room", "Welcome to Tia's room! Here you'll answer questions about Scrum.");

        Room roomBoard = new RoomBoard(multipleChoiceBehavior, "Board Room", "This is the board room.");

        // Add room to your rooms collection
        rooms.add(roomTia);
        rooms.add(roomBoard);
    }

    public void advanceRoom() {
        LOGGER.debug("Advancing room");

        if (player.getCurrentRoom() == rooms.size() - 1) {
            return;
        }

        this.player.increaseCurrentRoom();
    }

    public Room getCurrentRoom() {
        return rooms.get(player.getCurrentRoom());
    }

    public Menu getMainMenu() {
        return gameUI.createMainMenu();
    }

    public void saveProgress() {
        this.saveHandler.saveObj("player", player);
    }

    public void loadProgress() {
        this.player = this.saveHandler.loadObj("player", Player.class);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
     public void completedGame() {
        gameUI.showCompletionMessage();
        closeGame();
    }

    public void closeGame() {
        gameCloser.close();


    public void initialize() {
        // Is nog leeg, ik wil hier de startup logica voor gamestate samenvoegen/aanroepen - Casper
    }
}