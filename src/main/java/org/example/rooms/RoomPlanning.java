package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.MultipleChoice;
import org.example.Room;

public class RoomPlanning extends Room {
    private String introduction;
    private MultipleChoice question;
    private Answer[] answers;

    public RoomPlanning() {
        String[] answersTemp = {
                "Het team bepaalt hoeveel werk ze aankunnen",
                "Het team selecteert user stories uit de product backlog",
                "Het team splitst stories op in taken",
                "De Product Owner schrijft een uitgebreid eindrapport"
        };
        this.introduction = "Welkom in de Planningkamer!";
        this.question = new MultipleChoice("Welke taak hoort NIET thuis in de sprintplanning?", answersTemp);
        this.answers = question.getAnswers();
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        question.askQuestion();
    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
