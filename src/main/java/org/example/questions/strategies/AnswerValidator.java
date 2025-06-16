package org.example.questions.strategies;

public interface AnswerValidator<T, U> {
    boolean validateAnswer(T expected, U userInput);
}
