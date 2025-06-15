import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;

import java.util.List;
import java.util.ArrayList;

public class RoomFactoryStub implements IRoomFactory {

    @Override
    public List<Room> createRooms() {
        List<Room> stubRooms = new ArrayList<>();
        stubRooms.add(new RoomStub("Stub Room 1", "Dit is kamer 1"));
        stubRooms.add(new RoomStub("Stub Room 2", "Dit is kamer 2"));
        return stubRooms;
    }

    static class RoomStub extends Room {
        public RoomStub(String name, String description) {
            super(name, description);
        }

        @Override
        public String handleQuestion() {
            return "";
        }
    }
}
