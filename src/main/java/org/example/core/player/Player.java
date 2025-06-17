package org.example.core.player;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.events.GameEvent;
import org.example.events.ItemUsageEvent;
import org.example.updater.GameEventSubscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player implements GameEventSubscriber {
    private int currentRoom;
    private int roomsDone;
    private int jokersUsed;
    private Set<String> inventory = new HashSet<>();
    private final IOHandler ioHandler;

    public Player(){
        this.ioHandler = new ConsoleIOHandler();
        inventory.add("nuke");
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void increaseCurrentRoom() {
        currentRoom++;
    }

    public void setCurrentRoom(int roomIndex) {
        currentRoom = roomIndex;
    }

    public void getStatus() {
        ioHandler.display("Current Room: " + currentRoom);
        ioHandler.display("Rooms Done: " + roomsDone);
        ioHandler.display("Jokers Used: " + jokersUsed);
    }

    public void roomComplete() {
        roomsDone++;
    }

    public void jokerUsed() {
        jokersUsed++;
    }

    public void update(GameEvent event) {
        if (event instanceof ItemUsageEvent itemUsageEvent) {
            inventory.remove(itemUsageEvent.getItemName());
        }
    }
}
