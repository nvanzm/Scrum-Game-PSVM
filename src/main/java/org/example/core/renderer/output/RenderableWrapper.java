
package org.example.core.renderer.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.events.GameEvent;
import org.example.events.NewGameEvent;
import org.example.events.RoomEnterEvent;
import org.example.menus.handlers.InputHandler;
import org.example.updater.GameEventSubscriber;

public class RenderableWrapper implements Renderable, GameEventSubscriber {
    private Object item;
    private Renderer<Object> renderer;
    private InputHandler inputHandler;
    private static final Logger LOGGER = LogManager.getLogger();

    public RenderableWrapper(Object item, Renderer<?> renderer, InputHandler inputHandler) {
        this.item = item;
        this.renderer = (Renderer<Object>) renderer;
        this.inputHandler = inputHandler;
    }

    @Override
    public void render() {
        if (renderer != null && item != null) {
            renderer.render(item);
        }
    }

    public void setItem(Object item, Renderer<?> renderer, InputHandler inputHandler) {
        this.item = item;
        this.renderer = (Renderer<Object>) renderer;
        this.inputHandler = inputHandler;
        LOGGER.debug("RenderableWrapper updated with new item: {}", item.getClass().getSimpleName());
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public GameEvent handleInput(String input) {
        if (inputHandler != null) {
            return inputHandler.handleInput(input);
        } else {
            LOGGER.debug("No input handler set.");
            return null;
        }
    }

    @Override
    public void update(GameEvent event) {
        LOGGER.debug("RenderableWrapper received event: {}", event.getClass().getSimpleName());

        if (event instanceof NewGameEvent) {
            LOGGER.info("New game started - preparing to render first room");
        } else if (event instanceof RoomEnterEvent roomEvent) {
            LOGGER.info("Entering room: {}", roomEvent.getRoom().getRoomName());
        }

        // RenderableWrapper doesn't need to change its content here
        // as GameEngine handles the switching logic
    }
}