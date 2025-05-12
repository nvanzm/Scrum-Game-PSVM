package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomRetrospective extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomRetrospective() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "We moeten meer taakverdeling aan de Product Owner overlaten",
                "We moeten minder communiceren zodat er minder discussie is",
                "We moeten voortaan taken overslaan die niet duidelijk zijn",
                "We moeten het Scrum Board beter bijhouden en dagelijks afstemmen"
        };

        this.introduction = "Welkom in de Retrospective Kamer!";
        this.question = new MultipleChoice("Waar moet een “Epic” op het Scrum Board geplaatst worden?", answersTemp);
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
