package org.example.classes;

public abstract class Room {
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