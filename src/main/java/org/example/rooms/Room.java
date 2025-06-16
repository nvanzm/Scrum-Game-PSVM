package org.example.rooms;

import org.example.impediments.monster.Monster;

import java.util.Objects;

public abstract class Room {
    private Monster monster;

    private String roomName;
    private String welcomeMessage;

    protected Room(String roomName, String welcomeMessage) {
        this.roomName = Objects.requireNonNullElse(roomName, "Standard Room");
        this.welcomeMessage = Objects.requireNonNullElse(welcomeMessage, "Welcome to the Standard Room!");
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getRoomName() {
        return roomName;
    }

    public abstract String handleQuestion();
}