package org.example.core.renderer.output;

import org.example.rooms.Room;

public class RoomRenderer implements Renderer<Room> {
    @Override
    public void render(Room room) {
        System.out.println("== " + room.getRoomName() + " ==");
        System.out.println(room.getWelcomeMessage());
    }
}

