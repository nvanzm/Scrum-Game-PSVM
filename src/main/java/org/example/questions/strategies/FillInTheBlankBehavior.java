package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.hints.HintSelector;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.FillInTheBlankDisplayStrategy;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.displays.QuestionDisplayStrategy;
import org.example.rooms.templates.RoomPlanning;

import java.util.Scanner;

public class FillInTheBlankBehavior implements QuestionBehavior, AnswerValidator<String, String> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;
    private final HintSelector hintSelector;

    public FillInTheBlankBehavior(IOHandler ioHandler, HintSelector hintSelector) {
        this.displayStrategy = new FillInTheBlankDisplayStrategy();
        this.ioHandler = ioHandler;
        this.outcomeDisplay = new OutcomeDisplay();
        this.hintSelector = hintSelector;
    }


    @Override
    public String askQuestion(Question question) {
        while (true) {
            displayStrategy.displayQuestion(question, ioHandler);

            String choice = ioHandler.getTextInput();
            String answer = question.getCorrectAnswerFITB();

            if (validateAnswer(answer, choice)) {
                outcomeDisplay.displayCorrect(ioHandler, question);
                return "ADVANCE_ROOM";
            } else {
                outcomeDisplay.displayIncorrect(ioHandler);
                //joker of item gebruiken
                handleWrongAnswer();
            }
        }
    }

    public void handleWrongAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wil je een hint? (ja/nee)");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("ja")) {
            String hint = hintSelector.selectRandomHint().getHint();
            System.out.println(hint);
        } else {
            System.out.println("Geen hint gekozen.");
        }
    }


    @Override
    public boolean validateAnswer(String answer, String choice) {
        return choice.equalsIgnoreCase(answer);
    }
}
