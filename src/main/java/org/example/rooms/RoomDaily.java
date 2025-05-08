package org.example.rooms;

import org.example.Question;
import org.example.Room;

public class RoomDaily extends Room {
    Question question;

    RoomDaily() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "De Scrum Master",
                "De Product Owner",
                "De Stakeholder",
                "Een Developer"
        };

        this.question = new Question("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answersTemp);
    }
}
