package stubs;

import org.example.core.renderer.IOHandler;
import org.example.hints.HintSelector;
import org.example.questions.strategies.WrongAnswerHandler;

public class WrongAnswerHandlerStub extends WrongAnswerHandler {
    public boolean wrongAnswerCalled = false;

    @Override
    public void handleWrongAnswer(HintSelector hintSelector, IOHandler ioHandler) {
            wrongAnswerCalled = true;
            System.out.println("[Stub] Wil je een joker gebruiken?");
    }
}
