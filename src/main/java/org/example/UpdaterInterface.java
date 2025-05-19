package org.example;

public interface UpdaterInterface {
    void addSubscriber(UpdateSubscriber subscriber);
    void removeSubscriber(UpdateSubscriber subscriber);
    void updateAll();
}
