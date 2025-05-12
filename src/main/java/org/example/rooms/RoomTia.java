package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomTia extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomTia() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "Zorgen dat taken sneller klaar zijn, ongeacht kwaliteit",
                "Een streng plan opleggen dat altijd gevolgd moet worden",
                "Werknemers controleren met dagelijkse statusrapporten",
                "Flexibel en iteratief waarde leveren met continue verbetering"
        };

        this.introduction = "Welkom in de Finale TIA Kamer!";
        this.question = new MultipleChoice("Wat is het hoofddoel van Scrum binnen een team?", answersTemp);
        this.answers = question.getAnswers();
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        question.askQuestion();
    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
