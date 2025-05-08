package org.example;

public abstract class Room {
    Question[] questions;
    Monster monster;

    public void clearMonster() {

    }

    public Monster getMonster(){
        return monster;
    }
}