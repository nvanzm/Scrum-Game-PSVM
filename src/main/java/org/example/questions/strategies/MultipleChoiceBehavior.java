package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.Answer;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.AnswerValidator;
import org.example.questions.displays.MultipleChoiceDisplayStrategy;
import org.example.questions.displays.QuestionDisplayStrategy;

import java.util.Scanner;

public class MultipleChoiceBehavior implements QuestionBehavior, AnswerValidator {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;

    public MultipleChoiceBehavior(IOHandler ioHandler) {
        this.displayStrategy = new MultipleChoiceDisplayStrategy();
        this.ioHandler = ioHandler;
    }


    @Override
    public void askQuestion(Question question) {
        displayStrategy.displayQuestion(question, ioHandler);

        int choice = ioHandler.getNumericInput();
        Answer[] answers = question.getAnswers();

        if (validateAnswer(answers, choice)) {
            ioHandler.display("Correct!");
        } else {
            ioHandler.display("Helaas, dat is niet juist. Probeer het nog een keer!");
            askQuestion(question);
        }
    }

    @Override
    public boolean validateAnswer(Answer[] answers, int choice) {
        return answers[choice - 1].getCorrectness();
    }

}
