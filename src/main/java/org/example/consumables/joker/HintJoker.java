package org.example.consumables.joker;

import org.example.rooms.Room;

public class HintJoker implements Joker{
    String text;
    HintJoker(String text) {
        this.text = text;
    }

    @Override
    public void useIn(Room room) {
        System.out.println(text);
    }

    @Override
    public boolean isUsed() {
        return false;
    }
}
