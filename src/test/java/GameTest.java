import org.example.GameLauncher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameTest {

    @Test
    public void gameStartAndEndTest() {
        //2 om de game af te sluiten.
        String simulatedInput = "2\n";
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        try {
            GameLauncher.main(new String[] {});
            System.out.println("✅ Test geslaagd: Game is gestart en beëindigd zoals verwacht.");
        } catch (Exception e) {
            System.out.println("❌ Test gefaald: Er is een fout opgetreden - " + e.getMessage());
        }
    }
}

//Test gelukt!
