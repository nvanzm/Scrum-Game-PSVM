package org.example.core.player;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.updater.UpdateSubscriber;

public class Player implements UpdateSubscriber {
    private int currentRoom;
    private int roomsDone;
    private int jokersUsed;
    private final IOHandler ioHandler;

    Player(){
        this.ioHandler = new ConsoleIOHandler();
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
}
