package org.example;

public class Player {
    public int currentRoom;
    public int roomsDone;

    public void getStatus(){
        System.out.println("Current Room: " + currentRoom);
        System.out.println("Rooms Done: " + roomsDone);
    }

    public void roomDone(){
        roomsDone++;
    }
}
