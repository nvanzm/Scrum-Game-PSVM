package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;

import org.example.events.CorrectEvent;
import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;
import org.example.hints.HintSelector;
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
    private final HintSelector hintSelector;
    private final WrongAnswerHandler wrongAnswerHandler;

    public MultipleChoiceBehavior(IOHandler ioHandler, HintSelector hintSelector, OutcomeDisplay outcomeDisplay, WrongAnswerHandler wrongAnswerHandler) {
        this.displayStrategy = new MultipleChoiceDisplayStrategy();
        this.outcomeDisplay = outcomeDisplay;
        this.ioHandler = ioHandler;
        this.hintSelector = hintSelector;
        this.wrongAnswerHandler = wrongAnswerHandler;
    }

    @Override
    public GameEvent askQuestion(Question question) {
            displayStrategy.displayQuestion(question, ioHandler);

            int choice = ioHandler.getNumericInput();
            Answer[] answers = question.getAnswers();

            if (validateAnswer(answers, choice)) {
                outcomeDisplay.displayCorrect(ioHandler, question);
                return new CorrectEvent();
            } else {
                outcomeDisplay.displayIncorrect(ioHandler);
                //joker of item gebruiken
                wrongAnswerHandler.handleWrongAnswer(hintSelector, ioHandler);
                return new IncorrectAnswerEvent(question);
            }

    }

    public boolean validateAnswer(Answer[] answers, Integer choice) {
        return answers[choice - 1].getCorrectness();
    }
}
