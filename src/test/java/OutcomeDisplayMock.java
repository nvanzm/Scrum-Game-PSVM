package stubs;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.displays.OutcomeDisplay;

public class OutcomeDisplayMock extends OutcomeDisplay {
    public boolean displayedCorrect = false;
    public boolean displayedIncorrect = false;

    @Override
    public void displayCorrect(IOHandler ioHandler, Question question) {
        displayedCorrect = true;
    }

    @Override
    public void displayIncorrect(IOHandler ioHandler) {
        displayedIncorrect = true;
    }
}
