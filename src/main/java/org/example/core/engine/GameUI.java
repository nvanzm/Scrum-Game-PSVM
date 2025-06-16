package org.example.core.engine;

import org.example.menus.MainMenu;
import org.example.menus.Menu;

public class GameUI implements IGameUI {
    @Override
    public void showCompletionMessage() {
        System.out.println("Congrats! You've successfully completed the quiz!");
    }

    @Override
    public Menu createMainMenu() {
        return new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
    }
}