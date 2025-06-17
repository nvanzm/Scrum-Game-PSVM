package org.example.updater;

import org.example.events.GameEvent;

import java.util.Set;

public interface GameEventSubscriber {
    void update(GameEvent event);

    // Optional: specify which events this subscriber handles
    default Set<Class<? extends GameEvent>> getSubscribedEventTypes() {
        return Set.of(GameEvent.class); // Default to all events
    }
}
