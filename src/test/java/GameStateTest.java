import org.example.core.engine.GameState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {
    @Test
    void testAddRoom() {
        GameState gameState = new GameState();
        GameStateTestRoomStub roomStub = new GameStateTestRoomStub("Stubroom", "Welkom in de Stubroom");
        gameState.addRoom(roomStub);
        assertEquals(roomStub, gameState.getCurrentRoom());
    }


}
