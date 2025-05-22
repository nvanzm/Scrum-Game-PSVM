package org.example.rooms.templates;

import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;
import org.example.impediments.monster.Monster;
import org.example.questions.strategies.Pair;

import java.util.*;

public class RoomReview extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question;

    public RoomReview(QuestionBehavior questionType, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        questionType.askQuestion(question);
    }


}
