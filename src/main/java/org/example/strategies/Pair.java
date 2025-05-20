package org.example.strategies;

import org.example.classes.Answer;

import java.util.Objects;

public class Pair {
    private String key;
    private Answer value;

    public Pair(String key, Answer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Answer getValue() {
        return value;
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
