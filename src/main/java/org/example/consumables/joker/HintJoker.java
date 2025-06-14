package org.example.consumables.joker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.rooms.Room;

public class HintJoker implements Joker{
    String text;
    HintJoker(String text) {
        this.text = text;
    }
    private static final Logger LOGGER = LogManager.getLogger();


    @Override
    public void useIn(Room room) {
        LOGGER.debug("Using in room");
    }

    @Override
    public boolean isUsed() {
        return false;
    }
}
