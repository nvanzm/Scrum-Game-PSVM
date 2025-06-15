import org.example.core.engine.GameState;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    // Deze twee tests ineen omdat je voor de advance room check getcurrentroom nodig hebt
    @Test
    void testGetCurrentRoomAndAdvanceRoom() {
        IRoomFactory stubFactory = new RoomFactoryStub();
        GameState gameState = new GameState(stubFactory);

        Room current = gameState.getCurrentRoom();
        assertEquals("Stub Room 1", current.getRoomName());

        gameState.advanceRoom();

        current = gameState.getCurrentRoom();
        assertEquals("Stub Room 2", current.getRoomName());

        // Probeer nog een keer verder te gaan, zou niet verder moeten dan laatste
        gameState.advanceRoom();
        assertEquals("Stub Room 2", gameState.getCurrentRoom().getRoomName());
    }
}
