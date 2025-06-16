package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.Answer;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.MultipleChoiceDisplayStrategy;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.displays.QuestionDisplayStrategy;

public class MultipleChoiceBehavior implements QuestionBehavior, AnswerValidator<Answer[], Integer> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;

    public MultipleChoiceBehavior(IOHandler ioHandler) {
        this.displayStrategy = new MultipleChoiceDisplayStrategy();
        this.outcomeDisplay = new OutcomeDisplay();
        this.ioHandler = ioHandler;

    }


    @Override
    public String askQuestion(Question question) {
        while (true) {
            displayStrategy.displayQuestion(question, ioHandler);

            int choice = ioHandler.getNumericInput();
            Answer[] answers = question.getAnswers();

            if (validateAnswer(answers, choice)) {
                outcomeDisplay.displayCorrect(ioHandler, question);
                return "ADVANCE_ROOM";
            } else {
                outcomeDisplay.displayIncorrect(ioHandler);
                //joker of item gebruiken
            }
        }
    }

    public boolean validateAnswer(Answer[] answers, Integer choice) {
        return answers[choice - 1].getCorrectness();
    }
}
