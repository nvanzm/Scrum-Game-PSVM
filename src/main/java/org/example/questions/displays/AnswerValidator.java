package org.example.questions.displays;

import org.example.questions.Answer;

public interface AnswerValidator {
    boolean validateAnswer(Answer[] answers, int choice);
}
