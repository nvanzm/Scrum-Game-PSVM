package org.example.core.renderer.output;

import org.example.core.intents.Intent;
import org.example.menus.handlers.InputHandler;

public class RenderableWrapper implements Renderable {
    private Object item;
    private Renderer<Object> renderer;
    private InputHandler inputHandler;

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
            System.out.println("No input handler set.");
            return null;
        }
    }
}