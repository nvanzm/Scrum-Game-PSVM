package org.example.menus.handlers;

import org.example.core.intents.Intent;
import org.example.core.intents.InvalidInputIntent;
import org.example.core.intents.NavigationIntent;

public class MainMenuHandler implements InputHandler {
    @Override
    public String handleInput(String input) {
        if (input == null) {
            System.out.println("Ben je kkr dom? - sahid sinar");
        }

        switch (input) {
            case "1":
                return "SWITCH_TO_ROOM";
            case "2":
                return "EXIT";
            default:
               return "Your input is invalid";
        }
    }
}
