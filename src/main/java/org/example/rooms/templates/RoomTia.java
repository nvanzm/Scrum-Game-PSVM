package org.example.rooms.templates;

import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.events.ItemUsageEvent;
import org.example.events.NewGameEvent;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomTia extends Room {
    private QuestionBehavior questionBehavior;
    private Question question = new Question("Wat is het hoofddoel van Scrum binnen een team?", new String[]{
            "Zorgen dat taken sneller klaar zijn, ongeacht kwaliteit",
            "Een streng plan opleggen dat altijd gevolgd moet worden",
            "Werknemers controleren met dagelijkse statusrapporten",
            "Flexibel en iteratief waarde leveren met continue verbetering"
    },4, "Scrum");

    public RoomTia(QuestionBehavior questionBehavior, String roomName, String welcomeMessage, MonsterFactory monsterFactory) {
        super(roomName, welcomeMessage, monsterFactory);
        this.questionBehavior = questionBehavior;
    }
    
    @Override
    public GameEvent handleQuestion() {
        return questionBehavior.askQuestion(question);
    }

    public void update(GameEvent event) {
        if (event instanceof IncorrectAnswerEvent incorrectAnswerEvent && incorrectAnswerEvent.getQuestion().equals(question)) {
            LOGGER.info("RoomTia: Monster spawned!");
            this.monster = monsterFactory.createMonster();
        } else if (event instanceof ItemUsageEvent itemUsageEvent && itemUsageEvent.getItemName().equals("nuke") && hasMonster()) {
            LOGGER.info("RoomTia: Monster removed!");
            clearMonster();
        }
    }
}
