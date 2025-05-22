package org.example.consumables.joker;
import org.example.rooms.Room;

public interface Joker {
    void useIn(Room room);
    boolean isUsed();
}
