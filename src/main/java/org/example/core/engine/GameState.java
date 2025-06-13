package org.example.core.engine;


import org.example.core.player.Player;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.JsonHandler;
import org.example.core.renderer.SaveHandler;
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
    List<Room> rooms;
    Player player;
    SaveHandler saveHandler;

    public GameState() {
        rooms = new ArrayList<>();
        this.player = new Player();
        this.saveHandler = new JsonHandler();
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
        System.out.println(rooms);
        if (player.getCurrentRoom() == rooms.size() - 1) {
            return;
        }

        this.player.increaseCurrentRoom();
    }

    public Room getCurrentRoom() {
        return rooms.get(player.getCurrentRoom());
    }

    public Menu getMainMenu() {
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
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

    public void initialize() {

    }
}
