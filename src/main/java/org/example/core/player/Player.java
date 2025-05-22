package org.example.core.player;

import org.example.updater.UpdateSubscriber;
//import org.json.JSONObject;

public class Player implements UpdateSubscriber {
//    JSONObject JSON = new JSONObject();

    public int currentRoom;
    public int roomsDone;
    public int jokersUsed;

    public void getCurrentRoom() {
//        JSON.optInt("currentRoom", currentRoom);
    }

    public void setCurrentRoom(int room) {
        currentRoom = room;

        //Uitgecomment voor Casper, is een ideetje voor het opslaan van currentGame, ook in class Awnser heb ik wat uitgecomment

//        if (isCorrect) {
//            JSON.put("currentRoom", currentRoom);
//        }
//
//        JSON.optInt("currentRoom");
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
