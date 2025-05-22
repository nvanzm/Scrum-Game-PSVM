package org.example.core.engine;

import org.example.core.intents.Intent;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.output.*;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.questions.strategies.FillInTheBlank;
import org.example.questions.strategies.MultipleChoice;
import org.example.questions.strategies.Puzzle;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;
import org.example.rooms.templates.*;

import java.util.ArrayList;

public class GameEngine {
    private final Menu mainMenu;
    private final Menu chooseRoom;
    private final RenderableWrapper universalRenderer;
    private final InputService inputService = new InputService();
    private GameState gameState = new GameState();

    public GameEngine(Menu homeScherm, Menu chooseRoom) {
        this.mainMenu = homeScherm;
        this.chooseRoom = chooseRoom;

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);
    }

    public void launchGame() {
        gameState.setupRooms();
        gameLoop();
    }

    public void gameLoop() {
        boolean running = true;

        while (running) {
            // Render the current item (menu or room)
            universalRenderer.render();
            // Read input from the user
            String input = inputService.readLine();
            Intent intent = universalRenderer.handleInput(input);

            if (handleIntent(intent)) {
                running = false;
            }
        }
    }

    public boolean handleIntent(Intent intent) {
        if (intent == null) {
            return false;
        }

        return switch (intent.getAction()) {
            case "SWITCH_TO_ROOM" -> {
                Room currentRoom = gameState.getCurrentRoom();
                switchToRoom(currentRoom);
                yield false;
            }
            case "SWITCH_TO_MENU" -> {
                Menu mainMenu = gameState.getMainMenu();
                switchToMenu(mainMenu);
                yield false;
            }
            case "EXIT" -> true;
            default -> {
                System.out.println("Invalid input.");
                yield false;
            }
        };
    }

    public void switchToMenu(Menu newMenu) {
        universalRenderer.setItem(newMenu, new MenuRenderer(), new MainMenuHandler());
    }

    public void switchToRoom(Room newRoom) {
        universalRenderer.setItem(newRoom, new RoomRenderer(), null); // No input handler for rooms yet
    }
}
