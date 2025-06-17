
package org.example.core.engine;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.InputService;
import org.example.core.renderer.input.RoomInputHandler;
import org.example.core.renderer.output.MenuRenderer;
import org.example.core.renderer.output.RenderableWrapper;
import org.example.core.renderer.output.RoomRenderer;
import org.example.events.*;
import org.example.menus.Menu;
import org.example.menus.handlers.MainMenuHandler;
import org.example.rooms.Room;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.example.updater.GameEventSubscriber;

public class GameEngine implements GameEventSubscriber {
    private final IOHandler ioHandler;
    private final InputService inputService;
    private final RenderableWrapper universalRenderer;
    private final GameState gameState;
    private static final Logger LOGGER = LogManager.getLogger();
    private final EventBus eventBus;

    public GameEngine(GameEngineConfig config) {
        Menu mainMenu = config.mainMenu;
        this.ioHandler = config.ioHandler;
        this.inputService = config.inputService;
        this.eventBus = new EventBus();
        this.gameState = new GameState(config.roomFactory, config.gameCloser, config.gameUI);

        MenuRenderer menuRenderer = new MenuRenderer();
        MainMenuHandler mainMenuHandler = new MainMenuHandler();
        this.universalRenderer = new RenderableWrapper(mainMenu, menuRenderer, mainMenuHandler);

        setupSubscribers();
    }

    private void setupSubscribers() {
        // Subscribe GameEngine to events that require rendering changes
        eventBus.subscribe(ExitGameEvent.class, this);
        eventBus.subscribe(NewGameEvent.class, this);
        eventBus.subscribe(CorrectEvent.class, this);
        eventBus.subscribe(ToMenuEvent.class, this);

        // Subscribe RenderableWrapper to events it needs to handle
        eventBus.subscribe(NewGameEvent.class, universalRenderer);

        //
        for (Room room : gameState.getRooms()) {
            eventBus.subscribe(IncorrectAnswerEvent.class, room);
            eventBus.subscribe(ItemUsageEvent.class, room);
        }

        LOGGER.debug("All subscribers registered successfully");
    }

    public void launchGame() {
        gameLoop();
    }

    private void gameLoop() {
        boolean running = true;

        while (running) {
            universalRenderer.render();
            String input = inputService.readLine();
            GameEvent gameEvent = universalRenderer.handleInput(input);

            if (gameEvent != null) {
                LOGGER.debug("Processing event: {}", gameEvent.getClass().getSimpleName());

                // Publish event to all subscribers
                eventBus.publish(gameEvent);

                // Check if game should end
                if (shouldExitGame(gameEvent)) {
                    running = false;
                }
            }
        }
    }

    private boolean shouldExitGame(GameEvent event) {
        return event instanceof ExitGameEvent;
    }

    @Override
    public void update(GameEvent event) {
        LOGGER.debug("GameEngine received event: {}", event.getClass().getSimpleName());

        // Handle rendering changes based on events
        if (event instanceof NewGameEvent) {
            LOGGER.info("Starting new game - switching to first room");
            switchToRoom(gameState.getCurrentRoom());
        } else if (event instanceof CorrectEvent) {
            LOGGER.info("Correct answer - advancing to next room");
            gameState.advanceRoom();
            switchToRoom(gameState.getCurrentRoom());
        } else if (event instanceof ToMenuEvent) {
            switchToMenu(gameState.getMainMenu());
        }
    }

    private void switchToMenu(Menu newMenu) {
        LOGGER.debug("Switching to menu: {}", newMenu.getClass().getSimpleName());
        universalRenderer.setItem(newMenu, new MenuRenderer(), new MainMenuHandler());
    }

    private void switchToRoom(Room newRoom) {
        if (newRoom != null) {
            LOGGER.debug("Switching to room: {}", newRoom.getRoomName());
            RoomInputHandler roomInputHandler = new RoomInputHandler(ioHandler, newRoom);
            RoomRenderer roomRenderer = new RoomRenderer(ioHandler);
            universalRenderer.setItem(newRoom, roomRenderer, roomInputHandler);
        } else {
            LOGGER.warn("Attempted to switch to null room");
        }
    }
}