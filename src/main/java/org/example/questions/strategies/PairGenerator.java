package org.example.questions.strategies;

import org.example.questions.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PairGenerator {

    public static List<Pair> parsePairs(String input, Map<String, Answer> options) {
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
