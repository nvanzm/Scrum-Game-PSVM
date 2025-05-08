package org.example;

public class Answer {
    private String answerText;
    private boolean isCorrect;

    public Answer(String answerString) {
        this.answerText = answerString;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean getCorrectness() {
        return isCorrect;
    }

    public void setCorrectness(boolean correctness) {
        this.isCorrect = correctness;
    }
}
