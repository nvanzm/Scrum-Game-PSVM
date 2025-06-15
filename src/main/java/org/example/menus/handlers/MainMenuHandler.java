package org.example.menus.handlers;



public class MainMenuHandler implements InputHandler {
    @Override
    public String handleInput(String input) {
        if (input == null) {
            return null;
        }

        return switch (input) {
            case "1" -> "CONTINUE_GAME";
            case "2" -> "SWITCH_TO_ROOM";
            case "3" -> "EXIT";
            default -> "Your input is invalid";
        };
    }
}
