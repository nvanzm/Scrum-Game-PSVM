package org.example.questions.strategies;

import org.example.questions.Answer;

import java.util.Objects;

public class Pair {
    private String key;
    private Answer value;

    public Pair(String key, Answer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value.getAnswerText(), pair.value.getAnswerText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value.getAnswerText());
    }
}