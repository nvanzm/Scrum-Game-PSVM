package org.example;

import org.example.classes.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusTest {

    @Test
    public void testGetStatusPrintsCorrectOutput() {
        Player player = new Player();
        player.setCurrentRoom(2);
        player.roomComplete();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        player.getStatus();

        System.setOut(originalOut);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Current Room: 2"));
        assertTrue(output.contains("Rooms Done: 1"));

        player.setCurrentRoom(3);
        player.roomComplete();
        System.setOut(originalOut);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        player.getStatus();

        System.setOut(originalOut);

        output = outContent.toString().trim();
        assertTrue(output.contains("Current Room: 3"));
        assertTrue(output.contains("Rooms Done: 2"));
    }
}
