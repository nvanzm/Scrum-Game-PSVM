//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import org.example.ui.RoomMenu;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class RoomTest {
//
//    private final PrintStream originalOut = System.out;
//    private final java.io.InputStream originalIn = System.in;
//
//    private ByteArrayOutputStream outContent;
//
//    @BeforeEach
//    public void setUpStreams() {
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterEach
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setIn(originalIn);
//    }
//
//    @Test
//    public void testKamer3NietVrijGespeeld() {
//        String input = "kameaasd\nkamer1\n1\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        roomMenu menu = new roomMenu();
//        menu.optieMenu();
//
//        String output = outContent.toString();
//
//        assertTrue(output.contains("Onbekende invoer, probeer het opnieuw!"));
//    }
//}

//morgen doen