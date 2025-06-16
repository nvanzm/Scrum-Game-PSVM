import org.example.core.engine.IGameUI;
import org.example.menus.Menu;

public class GameUIStub implements IGameUI {

    @Override
    public void showCompletionMessage() {
        // Stub: doe niets
    }

    @Override
    public Menu createMainMenu() {
        // Stub: return een dummy menu
        return null;
    }
}
