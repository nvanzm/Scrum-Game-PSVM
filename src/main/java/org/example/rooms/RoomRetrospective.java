package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.QuestionBehavior;
import org.example.Room;

public class RoomRetrospective extends Room {
    private String introduction;
    private QuestionBehavior questionType;

    public RoomRetrospective(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Retrospective Kamer!";
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        questionType.askQuestion();
    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
