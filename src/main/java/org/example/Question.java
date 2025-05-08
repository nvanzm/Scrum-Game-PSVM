package org.example;

public class Question {
    public String questionText;
    public Answer[] answers;

    public Question(String questionText, String[] answerStrings) {
        this.questionText = questionText;

        for (int i = 0; i < answers.length; i++) {
            this.answers[i] = new Answer(answerStrings[i]);
        }

        answers[answers.length - 1].setCorrectness(true);
    }

    public String getQuestionText() {
        return questionText;
    }
}