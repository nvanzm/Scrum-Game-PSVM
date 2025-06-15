package org.example.rooms.templates;

import org.example.impediments.monster.Monster;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomRetrospective extends Room {
    private String introduction;
    private QuestionBehavior questionBehavior;
    private Question question = new Question("Wat is het belangrijkste doel van een retrospective in een Scrum-team?", new String[]{
            "Nieuwe features plannen voor de volgende sprint",
            "Het verdelen van taken tussen teamleden",
            "Het testen van software op bugs",
            "Het bespreken van wat goed ging en wat verbeterd kan worden in het teamproces"
    }, 4);

    public RoomRetrospective(QuestionBehavior questionBehavior, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionBehavior = questionBehavior;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    @Override
    public String handleQuestion() {
        return questionBehavior.askQuestion(question);
    }

}
