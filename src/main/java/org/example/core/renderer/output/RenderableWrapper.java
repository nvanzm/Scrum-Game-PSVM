package org.example.core.renderer.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.menus.handlers.InputHandler;

public class RenderableWrapper implements Renderable {
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
        renderer.render(item);
    }

    public void setItem(Object item, Renderer<?> renderer, InputHandler inputHandler) {
        this.item = item;
        this.renderer = (Renderer<Object>) renderer;
        this.inputHandler = inputHandler;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public String handleInput(String input) {
        if (inputHandler != null) {
            return inputHandler.handleInput(input);
        } else {
            LOGGER.debug("No input handler set.");
            return null;
        }
    }
}