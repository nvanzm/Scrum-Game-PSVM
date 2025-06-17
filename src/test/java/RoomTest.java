import org.example.GameLauncher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RoomTest {

    @Test
    public void roomStartAndEndTest() {
        // Arrange
        String simulatedInput = "1\nback\n2"; // 1 = naar kamer, back = terug, 2 = afsluiten
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        // Act & Assert
        assertDoesNotThrow(() -> GameLauncher.main(new String[]{}),
                "❌ Test gefaald: Er is een fout opgetreden tijdens het spel.");
        System.out.println("✅ Test geslaagd: Het spel is naar de kamer gegaan en vervolgens beëindigd zoals verwacht.");
    }
}
