package org.example.rooms.templates;

import org.example.impediments.monster.Monster;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

public class RoomRetrospective extends Room {
    private String introduction;
    private QuestionBehavior questionBehavior;
    private Question question = new Question("Vraag", new String[]{
            "Antwoord 1", "Antwoord 2", "Antwoord 3", "Antwoord 4"},4);

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
