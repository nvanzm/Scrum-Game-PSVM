package org.example.rooms;

import org.example.classes.Monster;
import org.example.classes.Question;
import org.example.classes.Room;
import org.example.interfaces.QuestionBehavior;

public class RoomPlanning extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question = new Question("Welk onderdeel hoort niet bij een sprintplanning?", new String[]{
            "Het team bepaalt hoeveel werk ze aankunnen",
            "Het team selecteert user stories uit de product backlog",
            "Het team splitst stories op in taken",
            "De Product Owner schrijft een uitgebreid eindrapport"
    }, 4);

    public RoomPlanning(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Planningkamer!";
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        questionType.askQuestion(question);
    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
