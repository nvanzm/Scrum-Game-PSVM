import org.example.rooms.Room;

public class GameStateTestRoomStub extends Room {
    GameStateTestRoomStub(String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
    }

    @Override
    public String handleQuestion() {
        return "";
    }
}
