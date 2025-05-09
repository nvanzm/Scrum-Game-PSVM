package org.example.rooms;

import org.example.MultipleChoice;
import org.example.Room;

public class RoomTia extends Room {
    MultipleChoice question;

    RoomTia() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "Zorgen dat taken sneller klaar zijn, ongeacht kwaliteit",
                "Een streng plan opleggen dat altijd gevolgd moet worden",
                "Werknemers controleren met dagelijkse statusrapporten",
                "Flexibel en iteratief waarde leveren met continue verbetering"
        };

        this.question = new MultipleChoice("Wat is het hoofddoel van Scrum binnen een team?", answersTemp);
    }
    public void introduction() {

    }

    public void handleQuestion() {

    }

    public void handleAnswer() {

    }
}
