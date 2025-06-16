package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.hints.HintSelector;

public class WrongAnswerHandler {
    public void handleWrongAnswer(HintSelector hintSelector, IOHandler ioHandler) {
        ioHandler.display("Wil je een hint? (ja/nee)");
        String input = ioHandler.getTextInput();

        if (input.equalsIgnoreCase("ja")) {
            String hint = hintSelector.selectRandomHint().getHint();
            ioHandler.display(hint);
        } else {
            ioHandler.display("Geen hint gekozen.");
        }
    }
}
