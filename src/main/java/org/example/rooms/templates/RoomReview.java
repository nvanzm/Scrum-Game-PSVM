package org.example.rooms.templates;

import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;
import org.example.impediments.monster.Monster;
import org.example.questions.strategies.Pair;

import java.util.*;

public class RoomReview extends Room {
    private QuestionBehavior questionBehavior;
    private Answer answer = new Answer("Stakeholders", true);
    private Question question = new Question("Wie geeft tijdens de Sprint Review feedback op het opgeleverde werk?", answer);

    public RoomReview(QuestionBehavior questionBehavior, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionBehavior = questionBehavior;
    }

    @Override
    public String handleQuestion() {
        return questionBehavior.askQuestion(question);
    }


}
