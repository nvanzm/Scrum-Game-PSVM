package org.example.rooms.templates;

import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.events.ItemUsageEvent;
import org.example.events.NewGameEvent;
import org.example.impediments.monster.Monster;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomPlanning extends Room {
    private QuestionBehavior questionBehavior;
    private Question question = new Question("Welk onderdeel hoort niet bij een sprintplanning?", new String[]{
            "Het team bepaalt hoeveel werk ze aankunnen",
            "Het team selecteert user stories uit de product backlog",
            "Het team splitst stories op in taken",
            "De Product Owner schrijft een uitgebreid eindrapport",
    }, 4, "Scrumplanning");

    public RoomPlanning(QuestionBehavior questionBehavior, String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
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
            LOGGER.info("RoomPlanning: Monster spawned!");
            this.monster = monsterFactory.createMonster();
        } else if (event instanceof ItemUsageEvent itemUsageEvent && itemUsageEvent.getItemName().equals("nuke") && hasMonster()) {
            LOGGER.info("RoomPlanning: Monster removed!");
            clearMonster();
        }
    }
}
