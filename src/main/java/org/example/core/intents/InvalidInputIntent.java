package org.example.core.intents;

public class InvalidInputIntent implements Intent {
    private String message;

    public InvalidInputIntent(String message) {
        this.message = message;
    }

    public String getAction() {
        return "NOTHING";
    }
}
