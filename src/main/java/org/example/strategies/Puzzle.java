package org.example.strategies;

import org.example.classes.Answer;
import org.example.classes.Question;
import org.example.interfaces.QuestionBehavior;

import java.util.*;

public class Puzzle implements QuestionBehavior {

    public void askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question.getQuestionText());

        Map<String, Answer> options = question.getOptions();
        List<Pair> correctPairs = question.getCorrectPairs();

        System.out.println("Koppel de volgende items:");
        for (Map.Entry<String, Answer> entry : options.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getAnswerText());
        }

        System.out.println("Voer je koppelingen in als: 1-a,2-c,3-b");
        String input = scanner.nextLine();
        List<Pair> userPairs = parsePairs(input, options);

        if (new HashSet<>(userPairs).equals(new HashSet<>(correctPairs))) {
            System.out.println("Correct!");
        } else {
            System.out.println("Niet juist, probeer opnieuw.");
            askQuestion(question);
        }
    }


    private List<Pair> parsePairs(String input, Map<String, Answer> options) {
        List<Pair> pairs = new ArrayList<>();
        String[] entries = input.split(",");
        for (String entry : entries) {
            String[] parts = entry.split("-");
            if (parts.length == 2 && options.containsKey(parts[1].trim())) {
                pairs.add(new Pair(parts[0].trim(), options.get(parts[1].trim())));
            }
        }
        return pairs;
    }
}
