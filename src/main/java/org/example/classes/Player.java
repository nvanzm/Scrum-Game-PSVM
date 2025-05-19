package org.example.classes;

import org.json.JSONObject;

public class Player {
//    JSONObject JSON = new JSONObject();
    public int currentRoom;
    public int roomsDone;

    public void getCurrentRoom() {
//        JSON.optInt("currentRoom", currentRoom);
    }

    public void setCurrentRoom(boolean isCorrect) {

        //Uitgecomment voor Casper, is een ideetje voor het opslaan van currentGame, ook in class Awnser heb ik wat uitgecomment
        //ook de boolean isCorrect heb ik toegepast van Awnser setCorrectness en hier in setCurrentRoom

//        if (isCorrect) {
//            JSON.put("currentRoom", currentRoom);
//        }
//
//        JSON.optInt("currentRoom");
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
