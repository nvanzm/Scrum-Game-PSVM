import org.example.core.engine.GameEngine;
import org.example.core.engine.IGameCloser;
import org.example.core.engine.IGameUI;
import org.example.core.engine.GameEngineConfig;
import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.InputService;
import org.example.menus.MainMenu;
import org.example.menus.RoomMenu;
import org.example.rooms.IRoomFactory;
import org.junit.jupiter.api.Test;
import stubs.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameEngineTest {

    @Test
    void testGameStartsAndEndsCleanly() {
        // Arrange
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");
        IGameUI gameUIStub = new GameUIStub();
        IRoomFactory roomFactoryStub = new RoomFactoryStub();
        IGameCloser gameCloserStub = new GameCloseStub();
        InputService inputServiceStub = new InputServiceStub("2");
        IOHandler ioHandlerStub = new IOHandlerStub(
                List.of(1, 2),
                List.of("2")
        );
        GameEngineConfig config = new GameEngineConfig(
                mainMenu,
                roomMenu,
                ioHandlerStub,
                inputServiceStub,
                roomFactoryStub,
                gameCloserStub,
                gameUIStub
        );
        GameEngine engine = new GameEngine(config);

        // Act & Assert
        assertDoesNotThrow(engine::launchGame, "GameEngine threw an exception during execution.");
        System.out.println("✅ Game is gestart en netjes gestopt.");
    }
}