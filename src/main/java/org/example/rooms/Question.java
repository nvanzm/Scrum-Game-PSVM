package org.example.rooms;

import org.example.QuestionBehavior;

public class Question {
    private QuestionBehavior questionbehavior;
    Question(QuestionBehavior questionbehavior) {
        this.questionbehavior = questionbehavior;
    }
    public void askQuestion() {
        questionbehavior.askQuestion();
    }
}
