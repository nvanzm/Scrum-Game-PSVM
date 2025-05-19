import org.example.classes.Game;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameTest {

    @Test
    public void testLaunchGame_NoExceptionAndStartsCorrectly() {
        String simulatedInput = "1\n\nkamer 1\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Game game = new Game();

        assertDoesNotThrow(game::launchGame);

        System.setIn(originalIn);
    }
}
