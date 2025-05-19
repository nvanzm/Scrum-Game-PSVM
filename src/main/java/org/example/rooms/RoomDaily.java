package org.example.rooms;

import org.example.classes.Answer;
import org.example.classes.Monster;
import org.example.classes.Question;
import org.example.classes.Room;
import org.example.interfaces.QuestionBehavior;

public class RoomDaily extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Answer answer = new Answer("Een developer", true);
    private Question question = new Question("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answer);

    public RoomDaily(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Daily Standup Kamer!";
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
