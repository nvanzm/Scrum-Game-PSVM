package org.example.classes;

import org.example.strategies.Pair;

import java.util.List;
import java.util.Map;

public class Question {
    private String questionText;
    private Answer[] answers;
    private Answer answerC;
    private List<Pair> correctPairs;
    private Map<String, Answer> options;

    public Question(String questionText, String[] answerTexts, int correctAnswer) {
        this.questionText = questionText;
        this.answers = new Answer[answerTexts.length];
        for (int i = 0; i < answerTexts.length; i++) {
            this.answers[i] = new Answer(answerTexts[i], false);
        }
        answers[correctAnswer - 1].setCorrectness(true);
    }

    public Question(String questionText, Answer answerC) {
        this.questionText = questionText;
        this.answerC = answerC;
        answerC.setCorrectness(true);
    }

    public Question(String questionText, Map<String, Answer> options, List<Pair> correctPairs) {
        this.questionText = questionText;
        this.options = options;
        this.correctPairs = correctPairs;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswerFITB() {
        return answerC.getAnswerText();
    }

    public String getCorrectAnswerMC() {
        for (Answer answer : answers) {
            if (answer.getCorrectness()) {
                return answer.getAnswerText();
            }
        }
        return null;
    }

    public List<Pair> getCorrectPairs() {
        return correctPairs;
    }

    public Map<String, Answer> getOptions() {
        return options;
    }
}
