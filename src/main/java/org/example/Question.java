package org.example;

public class Question {
    private String questionText;
    private Answer[] answers;

    public Question(String questionText, String[] answerStrings) {
        this.questionText = questionText;
        this.answers = new Answer[answerStrings.length];

        for (int i = 0; i < answerStrings.length; i++) {
            this.answers[i] = new Answer(answerStrings[i]);
        }

        this.answers[answers.length - 1].setCorrectness(true);
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}