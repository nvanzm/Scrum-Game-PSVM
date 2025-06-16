package org.example.core.renderer.output;

import org.example.core.renderer.IOHandler;
import org.example.rooms.Room;

public class RoomRenderer implements Renderer<Room> {
    IOHandler ioHandler;
    public RoomRenderer(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    @Override
    public void render(Room room) {
        System.out.println("\n=== " + room.getRoomName() + " ===");
        System.out.println(room.getWelcomeMessage());
        System.out.println("\nType 'back' to return to menu or any other key to continue...");
    }
}