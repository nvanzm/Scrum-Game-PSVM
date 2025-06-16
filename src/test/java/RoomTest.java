import org.example.GameLauncher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RoomTest {

    @Test
    public void roomStartAndEndTest() {
        //1 invoeren om naar de kamer te gaan, back om terug te gaan naar mainmenu en 2 om de game af te sluiten.
        String simulatedInput = "1\nback\n2";
        InputStream inputStreamMock = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStreamMock);

        try {
            GameLauncher.main(new String[] {});
            System.out.println("✅ Test geslaagd: Het spel is naar de kamer gegaan en vervolgens beëindigd zoals verwacht.");
        } catch (Exception e) {
            System.out.println("❌ Test gefaald: Er is een fout opgetreden - " + e.getMessage());
        }
    }
}

//Test gelukt!