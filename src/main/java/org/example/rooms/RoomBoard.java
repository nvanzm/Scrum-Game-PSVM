package org.example.rooms;

import org.example.Question;
import org.example.Room;

public class RoomBoard extends Room {
    Question question;

    RoomBoard() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "In de kolom ‘Done’",
                "Tussen de user stories, als reminder",
                "Onder de taken, als detail van werk",
                "Boven de user stories, als overkoepelend element"
        };

        this.question = new Question("Waar moet een “Epic” op het Scrum Board geplaatst worden?", answersTemp);
    }
}