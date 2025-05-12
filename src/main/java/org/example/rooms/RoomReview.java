package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomReview extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomReview() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "Leren van teamproblemen en verbeteren van samenwerking",
                "Het sprintplan maken voor de volgende sprint",
                "Een overzicht van het scrumproces geven aan nieuwe teamleden",
                "Het product tonen en feedback van stakeholders verzamelen"
        };

        this.introduction = "Welkom in de Sprint Review Kamer!";
        this.question = new MultipleChoice("Wat is een juist doel van een Sprint Review?", answersTemp);
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
