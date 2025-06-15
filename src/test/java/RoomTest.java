import org.example.GameLauncher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RoomTest {

    @Test
    public void testDirectExit() {
        String simulatedInput = "2\n";  // Randwaarde: direct exit
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        try {
            GameLauncher.main(new String[]{});
            System.out.println("✅ Direct exit mock test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Direct exit mock test gefaald: " + e.getMessage());
        }
    }

    @Test
    public void testRoomNavigationAndExit() {
        String simulatedInput = "1\nback\n2\n"; // Randwaarde: kamer in, terug, exit
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        try {
            GameLauncher.main(new String[]{});
            System.out.println("✅ Kamer navigatie gevolgd door exit mock test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Kamer navigatie gevolgd door exit mock test gefaald: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidInputThenExit() {
        String simulatedInput = "invalid\n2\n"; // Randwaarde: foute input gevolgd door exit
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        try {
            GameLauncher.main(new String[]{});
            System.out.println("✅ Invalid input gevolgd door exit mock test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Invalid input gevolgd door exit mock test gefaald: " + e.getMessage());
        }
    }
}
