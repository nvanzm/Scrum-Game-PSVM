package org.example.menus.handlers;


import org.example.events.*;

public class MainMenuHandler implements InputHandler {
    @Override
    public GameEvent handleInput(String input) {
        if (input == null) {
            return null;
        }

        return switch (input) {
            case "1" -> new NewGameEvent();
            case "2" -> new ExitGameEvent();
            default -> new IncorrectInputEvent();
        };
    }
}
