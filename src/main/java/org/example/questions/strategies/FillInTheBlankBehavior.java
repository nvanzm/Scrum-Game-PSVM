package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.FillInTheBlankDisplayStrategy;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.displays.QuestionDisplayStrategy;

public class FillInTheBlankBehavior implements QuestionBehavior, AnswerValidator<String, String> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;

    public FillInTheBlankBehavior(IOHandler ioHandler, OutcomeDisplay outcomeDisplay) {
        this.displayStrategy = new FillInTheBlankDisplayStrategy();
        this.ioHandler = ioHandler;
        this.outcomeDisplay = outcomeDisplay;
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
            }
        }
    }

    @Override
    public boolean validateAnswer(String answer, String choice) {
        return choice.equalsIgnoreCase(answer);
    }
}
