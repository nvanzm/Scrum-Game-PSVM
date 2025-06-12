package org.example.core.engine;

import org.example.core.intents.Intent;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.input.RoomInputHandler;
import org.example.core.renderer.output.*;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;
import org.example.rooms.templates.*;

public class GameEngine {
    private final Menu mainMenu;
    private final Menu chooseRoom;
    private final IOHandler ioHandler;  // Add this
    private final RenderableWrapper universalRenderer;
    private final InputService inputService = new InputService();
    private GameState gameState = new GameState();

    public GameEngine(Menu homeScherm, Menu chooseRoom) {
        this.mainMenu = homeScherm;
        this.chooseRoom = chooseRoom;
        this.ioHandler = new ConsoleIOHandler();

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);
    }

    public void launchGame() {
        setupGame();
        gameLoop();
    }

    private void setupGame() {
        // Create behaviors
        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler);

        // Create rooms with behaviors
        Room tiaRoom = new RoomTia(
                multipleChoiceBehavior,
                "Tia's Room",
                "Welcome to Tia's room! Answer Scrum questions to proceed."
        );

        // Add rooms to game state
        gameState.addRoom(tiaRoom);
        // Add more rooms as needed...

        gameState.initialize();  // Any additional setup needed
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
        RoomInputHandler roomInputHandler = new RoomInputHandler(ioHandler, newRoom);
        RoomRenderer roomRenderer = new RoomRenderer(ioHandler);  // Pass IOHandler to renderer
        universalRenderer.setItem(newRoom, roomRenderer, roomInputHandler);
    }


}
