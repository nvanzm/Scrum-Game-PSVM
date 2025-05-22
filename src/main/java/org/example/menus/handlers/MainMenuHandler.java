package org.example.menus.handlers;

import org.example.core.intents.Intent;
import org.example.core.intents.InvalidInputIntent;
import org.example.core.intents.NavigationIntent;

public class MainMenuHandler implements InputHandler {
    @Override
    public Intent handleInput(String input) {
        if (input == null) {
            System.out.println("Ben je kkr dom? - sahid sinar");
        }

        switch (input) {
            case "1":
                return new NavigationIntent("SWITCH_TO_ROOM");
            case "2":
                return new NavigationIntent("EXIT");
            default:
               return new InvalidInputIntent("Your input is invalid.");
        }
    }
}
