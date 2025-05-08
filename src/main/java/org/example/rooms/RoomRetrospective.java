package org.example.rooms;

import org.example.Question;
import org.example.Room;

public class RoomRetrospective extends Room {
    Question question;

    RoomRetrospective() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "We moeten meer taakverdeling aan de Product Owner overlaten",
                "We moeten minder communiceren zodat er minder discussie is",
                "We moeten voortaan taken overslaan die niet duidelijk zijn",
                "We moeten het Scrum Board beter bijhouden en dagelijks afstemmen"
        };

        this.question = new Question("Waar moet een “Epic” op het Scrum Board geplaatst worden?", answersTemp);
    }
}
