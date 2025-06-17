package org.example.events;

import org.example.updater.GameEventSubscriber;

import java.util.*;

public class EventBus {
    private final Map<Class<? extends GameEvent>, List<GameEventSubscriber>> subscribers;
    private final Queue<GameEvent> eventQueue;

    public EventBus() {
        this.subscribers = new HashMap<>();
        this.eventQueue = new LinkedList<>();
    }

    public <T extends GameEvent> void subscribe(Class<T> eventType, GameEventSubscriber subscriber) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(GameEventSubscriber subscriber) {
        subscribers.values().forEach(list -> list.remove(subscriber));
    }

    public void publish(GameEvent event) {
        List<GameEventSubscriber> eventSubscribers = subscribers.get(event.getClass());
        if (eventSubscribers != null) {
            eventSubscribers.forEach(subscriber -> subscriber.update(event));
        }
    }

    public void queue(GameEvent event) {
        eventQueue.offer(event);
    }

    public void processQueue() {
        while (!eventQueue.isEmpty()) {
            publish(eventQueue.poll());
        }
    }
}
