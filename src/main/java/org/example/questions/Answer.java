package org.example.questions;

public class Answer {
    private String answerText;
    private boolean isCorrect;

    public Answer(String answerString, boolean isCorrect) {
        this.answerText = answerString;
        this.isCorrect = isCorrect;
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