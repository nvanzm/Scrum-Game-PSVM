package org.example;

public abstract class Room {
    String introduction;
    Monster monster;

    public void runRoom() {
        introduction();
        handleQuestion();
    }

    public abstract void handleQuestion();
    public abstract void introduction();

    public Monster getMonster(){
        return monster;
    }
}