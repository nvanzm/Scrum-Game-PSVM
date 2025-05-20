package org.example;

import org.example.classes.Game;
import org.example.classes.RoomMenu;
import org.example.classes.MainMenu;

public class GameLauncher {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        RoomMenu roomMenu = new RoomMenu();
        Game game = new Game(mainMenu, roomMenu);
        game.launchGameAndPauseGame();
    }
}