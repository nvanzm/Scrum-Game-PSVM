package org.example.questions;

import org.example.questions.strategies.Pair;

import java.util.List;
import java.util.Map;

public class Question {
    private String questionText;
    private Answer[] answers;
    private Answer fillInTheBlankAnswer;
    private List<Pair> correctPairs;
    private Map<String, Answer> options;
    private String correctText;

    public Question(String questionText, String[] answerTexts, int correctAnswer, String correctText) {
        this.questionText = questionText;
        this.answers = new Answer[answerTexts.length];
        this.correctText = correctText;
        for (int i = 0; i < answerTexts.length; i++) {
            this.answers[i] = new Answer(answerTexts[i], false);
        }
        answers[correctAnswer - 1].setCorrectness(true);
    }

    public Question(String questionText, Answer fillInTheBlankAnswer, String correctText) {
        this.questionText = questionText;
        this.fillInTheBlankAnswer = fillInTheBlankAnswer;
        fillInTheBlankAnswer.setCorrectness(true);
        this.correctText = correctText;
    }

    public Question(String questionText, Map<String, Answer> options, List<Pair> correctPairs, String correctText) {
        this.questionText = questionText;
        this.options = options;
        this.correctPairs = correctPairs;
        this.correctText = correctText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public String getCorrectText() {return correctText;}

    public String getCorrectAnswerFITB() {
        return fillInTheBlankAnswer.getAnswerText();
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
