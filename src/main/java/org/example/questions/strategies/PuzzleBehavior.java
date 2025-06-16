package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.hints.HintSelector;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.displays.PuzzleDisplayStrategy;
import org.example.questions.displays.QuestionDisplayStrategy;

import java.util.*;

public class PuzzleBehavior implements QuestionBehavior, AnswerValidator<List<Pair> ,List<Pair>> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;
    private final HintSelector hintSelector;

    public PuzzleBehavior(IOHandler ioHandler, HintSelector hintSelector) {
        this.displayStrategy = new PuzzleDisplayStrategy();
        this.ioHandler = ioHandler;
        this.outcomeDisplay = new OutcomeDisplay();
        this.hintSelector = hintSelector;
    }

    @Override
    public String askQuestion(Question question) {
        while (true) {
            displayStrategy.displayQuestion(question, ioHandler);

            Map<String, Answer> options = question.getOptions();
            String choice = ioHandler.getTextInput();
            List<Pair> correctPairs = question.getCorrectPairs();

            List<Pair> userPairs = PairGenerator.parsePairs(choice, options);
            if (validateAnswer(userPairs, correctPairs)) {
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
    public boolean validateAnswer(List<Pair> correctPairs, List<Pair> userPairs) {
        return new HashSet<>(userPairs).equals(new HashSet<>(correctPairs));
    }
}