package org.example.joker;

import org.example.consumables.joker.Joker;
import org.example.rooms.Room;

public class KeyJoker implements Joker {
    boolean used = false;

    @Override
    public void useIn(Room room) {
        used = true;
        //return key;
    }

    @Override
    public boolean isUsed() {
        return used;
    }
}
