package org.example.joker;

import org.example.classes.Room;

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
