package org.example.menus;

import java.util.Objects;

public abstract class Menu {
    private final String menuName;
    private final String welcomeMessage;
    private final String[] options;

    protected Menu(String menuName, String welcomeMessage, String[] options) {
        this.menuName = Objects.requireNonNullElse(menuName, "Standard Menu");
        this.welcomeMessage = Objects.requireNonNullElse(welcomeMessage, "Welcome to the Standard Menu!");
        this.options = options;
    }

    public String getRoomName() {
        return menuName; // Default menu name, can be overridden
    }

    public String getWelcomeMessage() {
        return welcomeMessage; // Default message, can be overridden
    }

    public String[] getOptions() {
        return options;
    }

}