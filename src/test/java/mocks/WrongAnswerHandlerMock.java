package mocks;

import org.example.core.renderer.IOHandler;
import org.example.hints.HintSelector;
import org.example.questions.strategies.WrongAnswerHandler;

public class WrongAnswerHandlerMock extends WrongAnswerHandler {
    public boolean wasCalled = false;

    @Override
    public void handleWrongAnswer(HintSelector hintSelector, IOHandler ioHandler) {
        wasCalled = true;
        throw new RuntimeException("Stop de loop"); // stopt na 1 fout antwoord
    }
}
