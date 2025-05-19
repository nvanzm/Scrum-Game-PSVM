package org.example.classes;

import org.example.interfaces.UpdateSubscriber;
import org.example.interfaces.UpdaterInterface;

import java.util.ArrayList;
import java.util.List;

public class Updater implements UpdaterInterface {
    private List<UpdateSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(UpdateSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(UpdateSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void updateAll() {
        for (UpdateSubscriber subscriber : subscribers) {
            subscriber.roomComplete();
        }
    }
}