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
        ioHandler.display("\n=== " + room.getRoomName() + " ===");
        ioHandler.display(room.getWelcomeMessage());
        ioHandler.display("\nType 'back' to return to menu or any other key to continue...");
    }
}

