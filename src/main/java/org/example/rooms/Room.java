package org.example.rooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.events.GameEvent;
import org.example.impediments.monster.Monster;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.updater.GameEventSubscriber;

import java.util.Objects;

public abstract class Room implements GameEventSubscriber {
    protected Monster monster;
    protected MonsterFactory monsterFactory;
    private String roomName;
    private String welcomeMessage;
    protected static final Logger LOGGER = LogManager.getLogger();

    protected Room(String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
        this.roomName = Objects.requireNonNullElse(roomName, "Standard Room");
        this.welcomeMessage = Objects.requireNonNullElse(welcomeMessage, "Welcome to the Standard Room!");
        this.monsterFactory = monsterFactory;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getRoomName() {
        return roomName;
    }

    public abstract GameEvent handleQuestion();

    protected void spawnMonster() {
        this.monster = monsterFactory.createMonster();
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasMonster() {
        return monster != null;
    }

    public void clearMonster() {
        this.monster = null;
        LOGGER.info("Monster cleared from room: {}", roomName);
    }

}