package org.example.updater;

public interface UpdaterInterface {
    void addSubscriber(GameEventSubscriber subscriber);
    void removeSubscriber(GameEventSubscriber subscriber);
    void updateAll();
}
