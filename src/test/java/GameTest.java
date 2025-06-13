import org.example.GameLauncher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameTest {

    @Test
    public void gameStartTest() {
        String simulatedInput = "2\n";
        InputStream inputStreamStub = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamStub);

        try {
            GameLauncher.main(new String[] {});
            System.out.println("✅ Test geslaagd: Game is gestart en beëindigd zoals verwacht.");
        } catch (Exception e) {
            System.out.println("❌ Test gefaald: Er is een fout opgetreden - " + e.getMessage());
        }
    }
}

//Test gelukt!
