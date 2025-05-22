package org.example.rooms.templates;

import org.example.impediments.monster.Monster;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomTia extends Room {
    private QuestionBehavior questionType;
    private Question question = new Question("Wat is het hoofddoel van Scrum binnen een team?", new String[]{
            "Zorgen dat taken sneller klaar zijn, ongeacht kwaliteit",
            "Een streng plan opleggen dat altijd gevolgd moet worden",
            "Werknemers controleren met dagelijkse statusrapporten",
            "Flexibel en iteratief waarde leveren met continue verbetering"
    },4);

    public RoomTia(QuestionBehavior questionType, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionType = questionType;
    }


    public void handleQuestion() {
        questionType.askQuestion(question);
    }

}
