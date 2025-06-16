package org.example.questions.displays;

public interface AnswerValidator<T, U> {
    boolean validateAnswer(T expected, U userInput);
}
