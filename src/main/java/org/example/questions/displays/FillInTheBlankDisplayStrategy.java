package org.example.questions.displays;
import org.example.core.renderer.IOHandler;
import org.example.questions.Answer;
import org.example.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class FillInTheBlankDisplayStrategy implements QuestionDisplayStrategy {
    @Override
    public void displayQuestion(Question question, IOHandler ioHandler) {
        ioHandler.display(question.getQuestionText());

    }
}
