import org.example.core.engine.IGameCloser;

public class GameCloseStub implements IGameCloser {
    @Override
    public void close() {
        // Stub: doe niets, vermijd System.exit
    }
}