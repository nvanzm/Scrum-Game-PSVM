package org.example.rooms;

import org.example.MultipleChoice;
import org.example.Room;

public class RoomBoard extends Room {
    MultipleChoice question;

    RoomBoard() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "In de kolom ‘Done’",
                "Tussen de user stories, als reminder",
                "Onder de taken, als detail van werk",
                "Boven de user stories, als overkoepelend element"
        };

        this.question = new MultipleChoice("Waar moet een “Epic” op het Scrum Board geplaatst worden?", answersTemp);
    }
    public void introduction() {

    }

    public void handleQuestion() {

    }

    public void handleAnswer() {

    }
}