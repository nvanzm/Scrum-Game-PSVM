package org.example.rooms;

import org.example.classes.Answer;
import org.example.classes.Question;
import org.example.classes.Room;
import org.example.interfaces.QuestionBehavior;
import org.example.classes.Monster;
import org.example.strategies.Pair;

import java.util.*;

public class RoomReview extends Room {
    private String introduction;
    private QuestionBehavior questionType;
    private Question question;

    public RoomReview(QuestionBehavior questionType) {
        this.introduction = "Welkom in de Sprint Review Kamer!";
        this.questionType = questionType;

        Map<String, Answer> options = new LinkedHashMap<>();
        options.put("a", new Answer("Scrum Master", false));
        options.put("b", new Answer("Product Owner", false));
        options.put("c", new Answer("Developers", false));

        List<Pair> correctPairs = new ArrayList<>();
        correctPairs.add(new Pair("1", options.get("b"))); // Product Owner presenteert doelen
        correctPairs.add(new Pair("2", options.get("c"))); // Developers tonen werk
        correctPairs.add(new Pair("3", options.get("a"))); // Scrum Master faciliteert

        String vraagtekst = "Koppel elke rol aan zijn taak tijdens de Sprint Review:\n" +
                "1. Presenteert de sprintdoelen\n" +
                "2. Toont het gerealiseerde werk\n" +
                "3. Faciliteert het overleg";

        this.question = new Question(vraagtekst, options, correctPairs);
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
