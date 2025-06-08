package org.example.core.renderer.input;

import org.example.core.intents.NavigationIntent;
import org.example.core.renderer.IOHandler;
import org.example.menus.handlers.InputHandler;
import org.example.rooms.Room;

public class RoomInputHandler implements InputHandler {
    private final IOHandler ioHandler;
    private final Room room;

    public RoomInputHandler(IOHandler ioHandler, Room room) {
        this.ioHandler = ioHandler;
        this.room = room;
    }

    @Override
    public NavigationIntent handleInput(String input) {
        if (input.equalsIgnoreCase("back")) {
            return new NavigationIntent("SWITCH_TO_MENU");
        }

        room.handleQuestion();
        return null;
    }
}
