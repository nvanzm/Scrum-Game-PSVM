package org.example;

public class Question {
    private String questionText;
    private Answer[] answers;
    private Answer answerC;

    public Question(String questionText, String[] answerTexts) {
        this.questionText = questionText;
        this.answers = new Answer[answerTexts.length];
        for (int i = 0; i < answerTexts.length; i++) {
            this.answers[i] = new Answer(answerTexts[i], false); // Stel de juistheid tijdelijk in op false
        }
    }
    public Question(String questionText, Answer answerC) {
        this.questionText = questionText;
        this.answerC = answerC;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        for (Answer answer : answers) {
            if(answer.getCorrectness()){
                return answer.getAnswerText();
            }
        }
        return null;
    }
}
