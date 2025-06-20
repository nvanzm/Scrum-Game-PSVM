package org.example;

import org.example.core.engine.*;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.core.renderer.input.InputService;

import org.example.menus.RoomMenu;
import org.example.menus.MainMenu;
import org.example.core.engine.GameUI;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.strategies.WrongAnswerHandler;
import org.example.rooms.IRoomFactory;
import org.example.rooms.RoomFactory;

public class GameLauncher {

    public static void main(String[] args) {


        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom in de startkamer!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Roeom Menu", "HALLO!");

        IOHandler ioHandler = new ConsoleIOHandler();
        OutcomeDisplay outcomeDisplay = new OutcomeDisplay();
        WrongAnswerHandler wrongAnswerHandler = new WrongAnswerHandler();
        InputService inputService = new InputService();
        IRoomFactory roomFactory = new RoomFactory(ioHandler, outcomeDisplay, wrongAnswerHandler);
        IGameCloser gameCloser = new GameCloser();
        IGameUI gameUI = new GameUI();

        GameEngineConfig config = new GameEngineConfig(mainMenu, roomMenu, ioHandler, inputService, roomFactory, gameCloser, gameUI);
        GameEngine engine = new GameEngine(config);
        engine.launchGame();
    }
}