package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.AnswerValidator;
import org.example.questions.displays.MultipleChoiceDisplayStrategy;
import org.example.questions.displays.QuestionDisplayStrategy;

public class MultipleChoiceBehavior implements QuestionBehavior, AnswerValidator {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;

    public MultipleChoiceBehavior(IOHandler ioHandler) {
        this.displayStrategy = new MultipleChoiceDisplayStrategy();
        this.ioHandler = ioHandler;
    }

    @Override
    public String askQuestion(Question question) {
        while (true) {
            displayStrategy.displayQuestion(question, ioHandler);
            int choice = ioHandler.getNumericInput();
            Answer[] answers = question.getAnswers();

            if (validateAnswer(answers, choice)) {
                ioHandler.display("Correct!");
                return "ADVANCE_ROOM";
            } else {
                ioHandler.display("Helaas, dat is niet juist. Probeer het nog een keer!");
            }
        }
    }

    @Override
    public boolean validateAnswer(Answer[] answers, int choice) {
        return answers[choice - 1].getCorrectness();
    }

}
