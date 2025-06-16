package org.example.rooms.templates;

import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.strategies.Pair;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

import java.util.*;

public class RoomRetrospective extends Room {
    private QuestionBehavior questionBehavior;
    private Question question;


    public RoomRetrospective(QuestionBehavior questionBehavior, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionBehavior = questionBehavior;
        Map<String, Answer> options = new LinkedHashMap<>();
        options.put("a", new Answer("Wat ging goed", false));
        options.put("c", new Answer("Wat kon beter", false));
        options.put("b", new Answer("Wat nemen we mee naar de volgende sprint", false));

        List<Pair> correctPairs = new ArrayList<>();
        correctPairs.add(new Pair("1", options.get("a")));
        correctPairs.add(new Pair("2", options.get("c")));
        correctPairs.add(new Pair("3", options.get("b")));

        String vraagtekst = "Koppel de elementen van een retrospective (A t/m C) aan hun juiste focus (1 t/m 3)\n" +
                "1. Positieve punten om te herhalen\n" +
                "2. Aandachtspunten die verbetering nodig hebben\n" +
                "3. Acties of afspraken voor de toekomst";

        this.question = new Question(vraagtekst, options, correctPairs, "Retrospective");
    }

    @Override
    public String handleQuestion() {
        return questionBehavior.askQuestion(question);
    }

}
