package org.example.core.intents;

public class NavigationIntent implements Intent {
    private String action;

    public NavigationIntent(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
