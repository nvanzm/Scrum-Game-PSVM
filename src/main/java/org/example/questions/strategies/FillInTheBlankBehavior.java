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
    private final WrongAnswerHandler wrongAnswerHandler;

    public FillInTheBlankBehavior(IOHandler ioHandler, HintSelector hintSelector, OutcomeDisplay outcomeDisplay, WrongAnswerHandler wrongAnswerHandler) {
            this.displayStrategy = new FillInTheBlankDisplayStrategy();
        this.ioHandler = ioHandler;
        this.outcomeDisplay = outcomeDisplay;
        this.hintSelector = hintSelector;
        this.wrongAnswerHandler = wrongAnswerHandler;
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
                wrongAnswerHandler.handleWrongAnswer(hintSelector, ioHandler);
            }
        }
    }


    @Override
    public boolean validateAnswer(String answer, String choice) {
        return choice.equalsIgnoreCase(answer);
    }
}
