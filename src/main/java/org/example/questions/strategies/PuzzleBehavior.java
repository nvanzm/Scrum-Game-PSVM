package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.AnswerValidator;
import org.example.questions.displays.PuzzleDisplayStrategy;
import org.example.questions.displays.QuestionDisplayStrategy;

import java.util.*;

public class PuzzleBehavior implements QuestionBehavior, AnswerValidator<List<Pair> ,List<Pair>> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;

    public PuzzleBehavior(QuestionDisplayStrategy displayStrategy, IOHandler ioHandler) {
        this.displayStrategy = new PuzzleDisplayStrategy();
        this.ioHandler = ioHandler;
    }

    @Override
    public void askQuestion(Question question) {
        displayStrategy.displayQuestion(question, ioHandler);

        Map<String, Answer> options = question.getOptions();
        String choice = ioHandler.getTextInput();
        List<Pair> correctPairs = question.getCorrectPairs();

        List<Pair> userPairs = PairGenerator.parsePairs(choice, options);
        if (validateAnswer(userPairs, correctPairs)) {
            ioHandler.display("Correct!");
        }
        else {
            ioHandler.display("Helaas, het anwtwoord is fout!");
            askQuestion(question);
            //joker of item gebruiken
        }

    }

    @Override
    public boolean validateAnswer(List<Pair> correctPairs, List<Pair> userPairs) {
        return new HashSet<>(userPairs).equals(new HashSet<>(correctPairs));
    }
}