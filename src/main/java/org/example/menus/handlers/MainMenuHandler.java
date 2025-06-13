package org.example.menus.handlers;

import org.example.core.intents.Intent;
import org.example.core.intents.InvalidInputIntent;
import org.example.core.intents.NavigationIntent;

public class MainMenuHandler implements InputHandler {
    @Override
    public String handleInput(String input) {
        if (input == null) {
            System.out.println("");
        }

        assert input != null;
        return switch (input) {
            case "1" -> "CONTINUE_GAME";
            case "2" -> "SWITCH_TO_ROOM";
            case "3" -> "EXIT";
            default -> "Your input is invalid";
        };
    }
}
