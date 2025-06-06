package org.example.rooms;

import org.example.classes.Monster;
import org.example.classes.Question;
import org.example.classes.Room;
import org.example.interfaces.QuestionBehavior;

public class RoomRetrospective extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question = new Question("Vraag", new String[]{
            "Antwoord 1", "Antwoord 2", "Antwoord 3", "Antwoord 4"},4);

    public RoomRetrospective(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Retrospective Kamer!";
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
