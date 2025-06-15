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
            // Als geen input meer, geef default "2" om te stoppen
            return inputs.isEmpty() ? "2" : inputs.poll();
        }
    }

    @Test
    void testDirectExit() {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");

        InputServiceStub stub = new InputServiceStub("2"); // Randwaarde: direct exit
        GameEngine engine = new GameEngine(mainMenu, roomMenu, stub);

        try {
            engine.launchGame();
            System.out.println("✅ Direct exit test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Direct exit test gefaald: " + e.getMessage());
            assertTrue(false);
        }
    }

    @Test
    void testStartThenExit() {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");

        InputServiceStub stub = new InputServiceStub("1", "2"); // Randwaarde: start en dan exit
        GameEngine engine = new GameEngine(mainMenu, roomMenu, stub);

        try {
            engine.launchGame();
            System.out.println("✅ Start en daarna exit test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Start en daarna exit test gefaald: " + e.getMessage());
            assertTrue(false);
        }
    }

    @Test
    void testInvalidInputThenExit() {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");

        InputServiceStub stub = new InputServiceStub("invalid", "2"); // Randwaarde: foute input gevolgd door exit
        GameEngine engine = new GameEngine(mainMenu, roomMenu, stub);

        try {
            engine.launchGame();
            System.out.println("✅ Invalid input gevolgd door exit test geslaagd.");
        } catch (Exception e) {
            System.out.println("❌ Invalid input gevolgd door exit test gefaald: " + e.getMessage());
            assertTrue(false);
        }
    }
}
