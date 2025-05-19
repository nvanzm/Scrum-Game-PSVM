package org.example;

public class Player implements UpdateSubscriber{
    public int currentRoom;
    public int roomsDone;
    public int jokersUsed;

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int room) {
        currentRoom = room;
    }

    public void getStatus() {
        System.out.println("Current Room: " + currentRoom);
        System.out.println("Rooms Done: " + roomsDone);
        System.out.println("Jokers Used: " + jokersUsed);
    }

    public void roomComplete() {
        roomsDone++;
    }

    public void jokerUsed(){jokersUsed++;}
}
