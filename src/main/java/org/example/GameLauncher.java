package org.example;

import org.example.classes.Game;
import org.example.classes.roomMenu;
import org.example.classes.mainMenu;

public class GameLauncher {
    public static void main(String[] args) {
        mainMenu mainMenu = new mainMenu();
        roomMenu roomMenu = new roomMenu();
        Game game = new Game(mainMenu, roomMenu);
        game.launchGameAndPauseGame();
    }
}