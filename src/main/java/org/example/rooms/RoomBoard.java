package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomBoard extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomBoard() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "In de kolom ‘Done’",
                "Tussen de user stories, als reminder",
                "Onder de taken, als detail van werk",
                "Boven de user stories, als overkoepelend element"
        };

        this.introduction = "Welkom in de Scrumboard Kamer!";
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