package org.example.rooms;

import org.example.Monster;
import org.example.Question;
import org.example.Room;

public class RoomPlanning extends Room {
    Question question;

    RoomPlanning() {
        String[] answersTemp = {
                //Laatste antwoord is correct.
                "Het team bepaalt hoeveel werk ze aankunnen",
                "Het team selecteert user stories uit de product backlog",
                "Het team splitst stories op in taken",
                "De Product Owner schrijft een uitgebreid eindrapport"
        };

        this.question = new Question("Welke taak hoort NIET thuis in de sprintplanning?", answersTemp);
    }

    @Override
    public void clearMonster() {

    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
