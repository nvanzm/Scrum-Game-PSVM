package org.example.rooms;

import org.example.MultipleChoice;
import org.example.Room;

public class RoomReview extends Room {
    MultipleChoice question;

    RoomReview() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "Leren van teamproblemen en verbeteren van samenwerking",
                "Het sprintplan maken voor de volgende sprint",
                "Een overzicht van het scrumproces geven aan nieuwe teamleden",
                "Het product tonen en feedback van stakeholders verzamelen"
        };

        this.question = new MultipleChoice("Wat is een juist doel van een Sprint Review?", answersTemp);
    }
    public void introduction() {

    }

    public void handleQuestion() {

    }

    public void handleAnswer() {

    }
}
