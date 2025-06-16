import org.example.core.engine.GameEngine;
import org.example.core.engine.IGameCloser;
import org.example.core.engine.IGameUI;
import org.example.core.renderer.IOHandler;
import org.example.menus.MainMenu;
import org.example.menus.RoomMenu;
import org.example.core.renderer.input.InputService;
import org.example.rooms.IRoomFactory;
import org.junit.jupiter.api.Test;
import stubs.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class GameEngineTest {

    @Test
    void testGameIsStartedAndEnded() {
        MainMenu mainMenu = new MainMenu("Main Menu", "Welkom!", new String[]{"Start game", "Exit game"});
        RoomMenu roomMenu = new RoomMenu("Room Menu", "Room!");
        GameEngine engine = getGameEngine(mainMenu, roomMenu);

        try {
            engine.launchGame();
            System.out.println("✅ Game is gestart en netjes gestopt.");
        } catch (Exception e) {
            System.out.println("❌ Fout tijdens starten van de game: " + e.getMessage());
            fail("Exception thrown during game launch: " + e.getMessage());
        }
    }

    //Functie gemaakt ivm lange overbodige code (Code Smell: Long Method)
    private static GameEngine getGameEngine(MainMenu mainMenu, RoomMenu roomMenu) {
        IGameUI gameUIStub = new GameUIStub();
        IRoomFactory stubFactory = new RoomFactoryStub();
        IGameCloser stubGameCloser = new GameCloseStub();
        InputService inputServiceStub = new InputServiceStub("2");
        IOHandler ioHandlerStub = new IOHandlerStub(
                List.of(1, 2),
                List.of("testinput")
        );

        GameEngine engine = new GameEngine(
                mainMenu,
                roomMenu,
                ioHandlerStub,
                inputServiceStub,
                stubFactory,
                stubGameCloser,
                gameUIStub
        );
        return engine;
    }
}

//Test gelukt!