package org.example.rooms.templates;

import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.events.ItemUsageEvent;
import org.example.events.NewGameEvent;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomReview extends Room {
    private final QuestionBehavior questionBehavior;
    private final Answer answer = new Answer("Stakeholders", true);
    private final Question question = new Question("Wie geeft tijdens de Sprint Review feedback op het opgeleverde werk?", answer, "Sprint review");

    public RoomReview(QuestionBehavior questionBehavior, String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
        super(roomName, welcomeMessage, monsterFactory);
        this.questionBehavior = questionBehavior;
    }

    @Override
    public GameEvent handleQuestion() {
        return questionBehavior.askQuestion(question);
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof IncorrectAnswerEvent incorrectAnswerEvent && incorrectAnswerEvent.getQuestion().equals(question)) {
            LOGGER.info("RoomReview: Monster spawned!");
            this.monster = monsterFactory.createMonster();
        } else if (event instanceof ItemUsageEvent itemUsageEvent && itemUsageEvent.getItemName().equals("nuke") && hasMonster()) {
            LOGGER.info("RoomReview: Monster removed!");
            clearMonster();
        }
    }
}
