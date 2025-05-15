package org.example.rooms;

import org.example.*;

public class RoomReview extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question = new Question("Wat is een juist doel van een Sprint Review?", new String[]{
            "Leren van teamproblemen en verbeteren van samenwerking",
            "Het sprintplan maken voor de volgende sprint",
            "Een overzicht van het scrumproces geven aan nieuwe teamleden",
            "Het product tonen en feedback van stakeholders verzamelen"
    }, 4);

    public RoomReview(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Sprint Review Kamer!";
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
