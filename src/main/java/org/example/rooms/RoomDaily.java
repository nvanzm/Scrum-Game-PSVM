package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomDaily extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomDaily() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "De Scrum Master",
                "De Product Owner",
                "De Stakeholder",
                "Een Developer"
        };

        this.introduction = "Welkom in de Daily Standup Kamer!";
        this.question = new MultipleChoice("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answersTemp);
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
