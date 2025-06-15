import org.example.core.engine.GameEngine;
import org.example.core.renderer.input.InputService;
import org.example.menus.MainMenu;
import org.example.menus.RoomMenu;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    static class InputServiceStub extends InputService {
        private final Queue<String> inputs = new LinkedList<>();

        public InputServiceStub(String... inputs) {
            for (String input : inputs) {
                this.inputs.add(input);
            }
        }

        @Override
        public String readLine() {
            return inputs.isEmpty() ? "2" : inputs.poll();
        }
    }

    @Test
    void testGameIsStartedAndEnded() {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");

        InputServiceStub stub = new InputServiceStub("2");
        GameEngine engine = new GameEngine(mainMenu, roomMenu, stub);

        try {
            engine.launchGame();
            System.out.println("✅ Game is gestart en netjes gestopt.");
        } catch (Exception e) {
            System.out.println("❌ Fout tijdens starten van de game: " + e.getMessage());
            assertTrue(false);
        }
    }
}

//Test gelukt!