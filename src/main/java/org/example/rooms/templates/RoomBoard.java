package org.example.rooms.templates;

import org.example.impediments.monster.Monster;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomBoard extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question = new Question("Welk onderdeel hoort niet bij een sprintplanning?", new String[]{
            "Het team bepaalt hoeveel werk ze aankunnen",
            "Het team selecteert user stories uit de product backlog",
            "Het team splitst stories op in taken",
            "De Product Owner schrijft een uitgebreid eindrapport"
    },4);

    public RoomBoard(QuestionBehavior questionType, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public String handleQuestion() {
        return questionType.askQuestion(question);
    }


}