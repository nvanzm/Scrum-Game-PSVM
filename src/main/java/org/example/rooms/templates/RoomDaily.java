package org.example.rooms.templates;

import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.events.ItemUsageEvent;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomDaily extends Room {
    private QuestionBehavior questionType;
    private Answer answer = new Answer("Developer", true);
    private Question question = new Question("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answer, "Daily stand-up");

    public RoomDaily(QuestionBehavior questionType, String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
        super(roomName, welcomeMessage, monsterFactory);
        this.questionType = questionType;
    }

    public GameEvent handleQuestion() {
        return questionType.askQuestion(question);
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof IncorrectAnswerEvent incorrectAnswerEvent && incorrectAnswerEvent.getQuestion().equals(question)) {
            LOGGER.info("RoomDaily: Monster spawned!");
            this.monster = monsterFactory.createMonster();
        } else if (event instanceof ItemUsageEvent itemUsageEvent && itemUsageEvent.getItemName().equals("nuke") && hasMonster()) {
            LOGGER.info("RoomDaily: Monster removed!");
            clearMonster();
        }
    }
}
