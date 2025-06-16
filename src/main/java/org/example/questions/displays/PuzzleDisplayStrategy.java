package org.example.questions.displays;

import org.example.core.renderer.IOHandler;
import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.strategies.Pair;

import java.util.List;
import java.util.Map;

public class PuzzleDisplayStrategy implements QuestionDisplayStrategy {
    @Override
    public void displayQuestion(Question question,IOHandler ioHandler) {
        ioHandler.display(question.getQuestionText());

        Map<String, Answer> options = question.getOptions();

        for (Map.Entry<String, Answer> entry : options.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getAnswerText());
        }
        System.out.println("Voer je koppelingen in als: 1-a,2-c,3-b");
    }
}
