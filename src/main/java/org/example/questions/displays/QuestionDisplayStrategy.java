package org.example.questions.displays;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;

public interface QuestionDisplayStrategy {
    void displayQuestion(Question question, IOHandler ioHandler);
}