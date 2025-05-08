package org.example;

public class Player {
    public int currentRoom;
    public int roomsDone;

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom() {

    }

    public void getStatus() {
        System.out.println("Current Room: " + currentRoom);
        System.out.println("Rooms Done: " + roomsDone);
    }

    public void setStatus() {

    }

    public void roomDone() {
        roomsDone++;
    }
}
