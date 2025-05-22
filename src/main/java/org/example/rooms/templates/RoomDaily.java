package org.example.rooms.templates;

import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.rooms.Room;
import org.example.impediments.monster.Monster;
import org.example.questions.QuestionBehavior;

public class RoomDaily extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Answer answer = new Answer("Een developer", true);
    private Question question = new Question("Welk teamlid zou het volgende zeggen: “Ik loop vast op een bug en heb hulp nodig”?", answer);

    public RoomDaily(QuestionBehavior questionType, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionType = questionType;
    }

    public void introduction() {
        System.out.println(introduction);
    }

    public void handleQuestion() {
        questionType.askQuestion(question);
    }


}
