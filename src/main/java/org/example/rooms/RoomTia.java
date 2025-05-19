package org.example.rooms;

import org.example.classes.Monster;
import org.example.classes.Question;
import org.example.classes.Room;
import org.example.interfaces.QuestionBehavior;

public class RoomTia extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question = new Question("Wat is het hoofddoel van Scrum binnen een team?", new String[]{
            "Zorgen dat taken sneller klaar zijn, ongeacht kwaliteit",
            "Een streng plan opleggen dat altijd gevolgd moet worden",
            "Werknemers controleren met dagelijkse statusrapporten",
            "Flexibel en iteratief waarde leveren met continue verbetering"
    },4);

    public RoomTia(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Finale TIA Kamer!";
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        questionType.askQuestion(question);
    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
