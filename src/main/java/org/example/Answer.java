package org.example;

public class Answer {
    public String answerText;
    public boolean isCorrect;

    public Answer(String answerString) {
        this.answerText = answerString;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean getCorrectness(){
        return isCorrect;
    }

    public void setCorrectness(boolean Correctness) {
        this.isCorrect = Correctness;
    }
}
