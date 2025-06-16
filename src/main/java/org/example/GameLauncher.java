package org.example;

import org.example.core.engine.*;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.core.renderer.input.InputService;
import org.example.hints.FunnyHintRoomPlanning;
import org.example.hints.HelpHintRoomPlanning;
import org.example.hints.HintProvider;
import org.example.hints.HintSelector;
import org.example.menus.RoomMenu;
import org.example.menus.MainMenu;
import org.example.core.engine.GameUI;
import org.example.rooms.IRoomFactory;
import org.example.rooms.RoomFactory;

import java.util.List;

public class GameLauncher {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "HALLO!");

        IOHandler ioHandler = new ConsoleIOHandler();
        InputService inputService = new InputService();
        IRoomFactory roomFactory = new RoomFactory(ioHandler);
        IGameCloser gameCloser = new GameCloser();
        IGameUI gameUI = new GameUI();

        GameEngine engine = new GameEngine(mainMenu, roomMenu, ioHandler, inputService, roomFactory, gameCloser, gameUI);
        engine.launchGame();
    }
}