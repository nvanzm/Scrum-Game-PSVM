package org.example.core.engine;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.InputService;
import org.example.menus.Menu;
import org.example.rooms.IRoomFactory;

public class GameEngineConfig {
        public final Menu mainMenu;
        public final Menu chooseRoom;
        public final IOHandler ioHandler;
        public final InputService inputService;
        public final IRoomFactory roomFactory;
        public final IGameCloser gameCloser;
        public final IGameUI gameUI;

        public GameEngineConfig(
                Menu mainMenu,
                Menu chooseRoom,
                IOHandler ioHandler,
                InputService inputService,
                IRoomFactory roomFactory,
                IGameCloser gameCloser,
                IGameUI gameUI
        ) {
            this.mainMenu = mainMenu;
            this.chooseRoom = chooseRoom;
            this.ioHandler = ioHandler;
            this.inputService = inputService;
            this.roomFactory = roomFactory;
            this.gameCloser = gameCloser;
            this.gameUI = gameUI;
        }
}
