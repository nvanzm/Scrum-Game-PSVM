package org.example.core.engine;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.input.RoomInputHandler;
import org.example.core.renderer.output.MenuRenderer;
import org.example.core.renderer.output.RenderableWrapper;
import org.example.core.renderer.output.RoomRenderer;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.rooms.Room;

public class GameEngine {
    private final Menu mainMenu;
    private final Menu chooseRoom;
    private final IOHandler ioHandler;
    private final RenderableWrapper universalRenderer;
    private final InputService inputService;
    private final GameState gameState = new GameState();

    public GameEngine(Menu mainMenu, Menu chooseRoom) {
        this(mainMenu, chooseRoom, new ConsoleIOHandler(), new InputService());
    }

    public GameEngine(Menu mainMenu, Menu chooseRoom, InputService inputService) {
        this(mainMenu, chooseRoom, new ConsoleIOHandler(), inputService);
    }

    public GameEngine(Menu mainMenu, Menu chooseRoom, IOHandler ioHandler, InputService inputService) {
        this.mainMenu = mainMenu;
        this.chooseRoom = chooseRoom;
        this.ioHandler = ioHandler;
        this.inputService = inputService;

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);
    }

    public void launchGame() {
        setupGame();
        gameLoop();
    }

    private void setupGame() {
        gameState.setupRooms();
        gameState.initialize();
    }

    private void gameLoop() {
        boolean running = true;

        while (running) {
            universalRenderer.render();
            String input = inputService.readLine();
            String intent = universalRenderer.handleInput(input);
            running = !handleIntent(intent);
        }
    }

    public boolean handleIntent(String intent) {
        if (intent == null) return false;

        return switch (intent) {
            case "ADVANCE_ROOM" -> {
                gameState.advanceRoom();
                Room currentRoom = gameState.getCurrentRoom();
                System.out.println("You have advanced to room: " + currentRoom.getRoomName());
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
        RoomRenderer roomRenderer = new RoomRenderer(ioHandler);
        universalRenderer.setItem(newRoom, roomRenderer, roomInputHandler);
    }
}
