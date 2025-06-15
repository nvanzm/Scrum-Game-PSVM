package org.example.core.engine;

public class GameCloser implements IGameCloser {

    @Override
    public void close() {
        System.exit(0);
    }
}
