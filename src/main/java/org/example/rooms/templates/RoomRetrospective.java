package org.example.rooms.templates;

import org.example.questions.Answer;
import org.example.questions.Question;
import org.example.questions.strategies.Pair;
import org.example.questions.strategies.PairGenerator;
import org.example.rooms.Room;
import org.example.questions.QuestionBehavior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRetrospective extends Room {
    private QuestionBehavior questionBehavior;
    private Map<String, Answer> options = new HashMap<>();
    private List<Pair> correctPairs = PairGenerator.parsePairs("1-a,", options);
    private Question question = new Question("Koppel de elementen van een retrospective (A t/m C) aan hun juiste focus (1 t/m 3):", options, correctPairs);


    public RoomRetrospective(QuestionBehavior questionBehavior, String roomName, String welcomeMessage) {
        super(roomName, welcomeMessage);
        this.questionBehavior = questionBehavior;
        options.put("A", new Answer("Wat ging goed", false));
        options.put("B", new Answer("Wat nemen we mee naar de volgende sprint", false));
        options.put("C", new Answer("Wat kon beter", false));
        options.put("1", new Answer("Positieve punten om te herhalen", false));
        options.put("2", new Answer("Aandachtspunten die verbetering nodig hebben", false));
        options.put("3", new Answer("Acties of afspraken voor de toekomst", false));
    }

    @Override
    public String handleQuestion() {
        return questionBehavior.askQuestion(question);
    }

}
