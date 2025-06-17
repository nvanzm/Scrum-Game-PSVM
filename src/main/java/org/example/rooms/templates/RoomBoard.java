package org.example.rooms.templates;

import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.events.ItemUsageEvent;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomBoard extends Room {
    private QuestionBehavior questionType;
    private Question question = new Question("Welk onderdeel hoort niet bij een sprintplanning?", new String[]{
            "Het team bepaalt hoeveel werk ze aankunnen",
            "Het team selecteert user stories uit de product backlog",
            "Het team splitst stories op in taken",
            "De Product Owner schrijft een uitgebreid eindrapport"
    },4, "Scrumboard");

    public RoomBoard(QuestionBehavior questionType, String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
        super(roomName, welcomeMessage, monsterFactory);
        this.questionType = questionType;
    }

    public GameEvent handleQuestion() {
        return questionType.askQuestion(question);
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof IncorrectAnswerEvent incorrectAnswerEvent && incorrectAnswerEvent.getQuestion().equals(question)) {
            LOGGER.info("RoomBoard: Monster spawned!");
            this.monster = monsterFactory.createMonster();
        } else if (event instanceof ItemUsageEvent itemUsageEvent && itemUsageEvent.getItemName().equals("nuke") && hasMonster()) {
            LOGGER.info("RoomBoard: Monster removed!");
            clearMonster();
        }
    }
}