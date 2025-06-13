package org.example.core.player;

import org.example.updater.UpdateSubscriber;
//import org.json.JSONObject;

public class Player implements UpdateSubscriber {

    public int currentRoom;
    public int roomsDone;
    public int jokersUsed;

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
        System.out.println("Current Room: " + currentRoom);
        System.out.println("Rooms Done: " + roomsDone);
        System.out.println("Jokers Used: " + jokersUsed);
    }

    public void roomComplete() {
        roomsDone++;
    }

    public void jokerUsed() {
        jokersUsed++;
    }
}
