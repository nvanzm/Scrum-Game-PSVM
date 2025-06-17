package org.example.events;

import org.example.questions.Question;

public class IncorrectAnswerEvent extends GameEvent{
    private Question question;

    public IncorrectAnswerEvent(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }
}
