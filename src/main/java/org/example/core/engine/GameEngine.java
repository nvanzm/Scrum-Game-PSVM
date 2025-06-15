package org.example.core.engine;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.input.RoomInputHandler;
import org.example.core.renderer.output.*;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.rooms.Room;
import org.example.rooms.RoomFactory;

public class GameEngine {
    private final Menu mainMenu;
    private final Menu chooseRoom;
    private final IOHandler ioHandler;  // Add this
    private final RenderableWrapper universalRenderer;
    private final InputService inputService = new InputService();
    private GameState gameState;

    public GameEngine(Menu homeScherm, Menu chooseRoom) {
        this.mainMenu = homeScherm;
        this.chooseRoom = chooseRoom;
        this.ioHandler = new ConsoleIOHandler();

        this.gameState = new GameState(new RoomFactory(ioHandler), new GameCloser());

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);
    }

    public void launchGame() {
        gameLoop();
    }

    public void gameLoop() {
        boolean running = true;

        while (running) {
            // Render the current item (menu or room)
            universalRenderer.render();
            // Read input from the user
            String input = inputService.readLine();
            String intent = universalRenderer.handleInput(input);

            if (handleIntent(intent)) {
                running = false;
            }
        }
    }

    public boolean handleIntent(String intent) {
        if (intent == null) {
            return false;
        }

        return switch (intent) {
            case "ADVANCE_ROOM" -> {
                gameState.advanceRoom();
                System.out.println("You have advanced to room " + gameState.getCurrentRoom().getRoomName());
                Room currentRoom = gameState.getCurrentRoom();
                switchToRoom(currentRoom);
                yield false;
            }
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
            case "EXIT" -> {
                System.out.println("Exiting the game...");
                yield true;
            }
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