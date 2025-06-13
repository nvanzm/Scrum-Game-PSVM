package org.example;

import org.example.core.engine.GameEngine;
import org.example.menus.RoomMenu;
import org.example.menus.MainMenu;

public class GameLauncher {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "HALLO!");

        GameEngine engine = new GameEngine(mainMenu, roomMenu);
        engine.launchGame();
    }
}