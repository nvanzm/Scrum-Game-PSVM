//import org.example.classes.Game;
//import org.example.classes.Menu;
//import org.example.classes.mainMenu;
//import org.example.classes.roomMenu;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//
//public class GameTest {
//
//    @Test
//    public void testLaunchGame() {
//        Menu roomMenu = new roomMenu();
//        Menu mainMenu = new mainMenu();
//
//        //Hierin testen wij of de game succesvol opstart en de introductie en opdracht kan tonen.
//        String simulatedInput = "1\n\nkamer 1";
//        InputStream originalIn = System.in;
//        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
//
//        Game game = new Game(roomMenu, mainMenu);
//
//        assertDoesNotThrow(game::launchGameAndPauseGame);
//
//        System.setIn(originalIn);
//    }
//}

//morgen verder