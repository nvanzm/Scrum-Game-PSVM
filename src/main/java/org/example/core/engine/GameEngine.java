package org.example.core.engine;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.input.RoomInputHandler;
import org.example.core.renderer.output.MenuRenderer;
import org.example.core.renderer.output.RenderableWrapper;
import org.example.core.renderer.output.RoomRenderer;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.rooms.Room;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;


public class GameEngine {
    private final IOHandler ioHandler;
    private final InputService inputService;
    private final RenderableWrapper universalRenderer;
    private final GameState gameState;
    private final Menu mainMenu;
    private final IOHandler ioHandler;  // Add this
    private final RenderableWrapper universalRenderer;
    private final InputService inputService = new InputService();
    private final GameState gameState = new GameState();
    private static final Logger LOGGER = LogManager.getLogger();
    private final Menu chooseRoom;

    public GameEngine(GameEngineConfig config) {
        this.mainMenu = config.mainMenu;
        this.chooseRoom = config.chooseRoom;
        this.ioHandler = config.ioHandler;
        this.inputService = config.inputService;
        this.gameState = new GameState(config.roomFactory, config.gameCloser, config.gameUI);

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);
    }

    public void launchGame() {
        gameLoop();
    }

    private void gameLoop() {
        boolean running = true;

        while (running) {
            universalRenderer.render();
            String input = inputService.readLine();
            String intent = universalRenderer.handleInput(input);
            if (handleIntent(intent)) {
                running = false;
            }
        }
    }

    private boolean handleIntent(String intent) {
        if (intent == null) return false;

        return switch (intent) {
            case "ADVANCE_ROOM" -> {
                gameState.advanceRoom();
                LOGGER.debug("Advancing to room: %s", gameState.getCurrentRoom());
                Room currentRoom = gameState.getCurrentRoom();
             
                switchToRoom(gameState.getCurrentRoom());

                yield false;
            }
            case "SWITCH_TO_ROOM" -> {
                switchToRoom(gameState.getCurrentRoom());
                yield false;
            }
            case "CONTINUE_GAME" -> {
                this.gameState.loadProgress();
                Room currentRoom = gameState.getCurrentRoom();
                switchToRoom(currentRoom);
                yield false;
            }
            case "SWITCH_TO_MENU" -> {

                switchToMenu(gameState.getMainMenu());
                yield false;
            }
            case "EXIT" -> {
                System.out.println("Exiting the game...");
                yield true;
            }
            default -> {
                LOGGER.debug("Invalid input");
                this.gameState.saveProgress();
                yield false;
            }
        };
    }

    private void switchToMenu(Menu newMenu) {
        universalRenderer.setItem(newMenu, new MenuRenderer(), new MainMenuHandler());
    }

    private void switchToRoom(Room newRoom) {
        RoomInputHandler roomInputHandler = new RoomInputHandler(ioHandler, newRoom);
        RoomRenderer roomRenderer = new RoomRenderer(ioHandler);
        universalRenderer.setItem(newRoom, roomRenderer, roomInputHandler);
    }
}