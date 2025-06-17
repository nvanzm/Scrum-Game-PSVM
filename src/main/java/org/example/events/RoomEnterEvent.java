package org.example.events;

import org.example.rooms.Room;

public class RoomEnterEvent extends GameEvent {
    private final Room room;

    public RoomEnterEvent(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}