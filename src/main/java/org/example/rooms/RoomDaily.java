package org.example.rooms;

import org.example.MultipleChoice;
import org.example.Room;

public class RoomDaily extends Room {
    MultipleChoice question;

    RoomDaily() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "De Scrum Master",
                "De Product Owner",
                "De Stakeholder",
                "Een Developer"
        };

        this.question = new MultipleChoice("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answersTemp);
    }

    public void introduction() {

    }

    public void handleQuestion() {

    }

    public void handleAnswer() {

    }
}
