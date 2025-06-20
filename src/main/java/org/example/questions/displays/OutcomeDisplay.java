package org.example.questions.displays;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.rooms.templates.RoomPlanning;

public class OutcomeDisplay {
    public void displayCorrect(IOHandler ioHandler, Question question) {
        ioHandler.display("Je hebt de vraag over "+question.getCorrectText()+" correct beantwoord!");
    }
    public void displayIncorrect(IOHandler ioHandler) {
        ioHandler.display("Helaas, dat is niet juist. Probeer het nog een keer en lees de vraag nog eens extra goed!");
    }
}
