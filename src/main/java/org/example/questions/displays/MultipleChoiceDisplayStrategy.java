package org.example.questions.displays;

import org.example.core.renderer.IOHandler;
import org.example.questions.Answer;
import org.example.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceDisplayStrategy implements QuestionDisplayStrategy {
    @Override
    public void displayQuestion(Question question, IOHandler ioHandler) {
        ioHandler.display(question.getQuestionText());

        Answer[] answers = question.getAnswers();
        List<String> options = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            options.add((i + 1) + ". " + answers[i].getAnswerText());
        }

        ioHandler.displayOptions(options);
    }
}