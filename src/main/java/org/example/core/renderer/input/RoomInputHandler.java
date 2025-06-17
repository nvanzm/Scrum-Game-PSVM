package org.example.core.renderer.input;

import org.example.core.renderer.IOHandler;
import org.example.events.GameEvent;
import org.example.events.ItemUsageEvent;
import org.example.events.ToMenuEvent;
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
    public GameEvent handleInput(String input) {
        if (input.equalsIgnoreCase("back")) {
            return new ToMenuEvent();
        } else if (input.contains("use")) {
            String itemName = input.substring(input.indexOf("use") + 3).trim(); // +3 skips "use"
            return new ItemUsageEvent(itemName);
        }


        return room.handleQuestion();
    }
}
