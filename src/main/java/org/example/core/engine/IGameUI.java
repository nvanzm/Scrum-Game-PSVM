package org.example.core.engine;

import org.example.menus.Menu;

public interface IGameUI {
    void showCompletionMessage();
    Menu createMainMenu();
}