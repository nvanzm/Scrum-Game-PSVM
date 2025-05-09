package org.example;

import org.example.rooms.Question;

import java.util.Scanner;

public class MultipleChoice implements QuestionBehavior {
    private String questionText;
    private Answer[] answers;

    public MultipleChoice(String questionText, String[] answerStrings) {
        this.questionText = questionText;
        this.answers = new Answer[answerStrings.length];

        for (int i = 0; i < answerStrings.length; i++) {
            this.answers[i] = new Answer(answerStrings[i]);
        }

        this.answers[answers.length - 1].setCorrectness(true);
    }

    public void askQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < answers.length; i++) {
            System.out.println((i + 1) + ". " + answers[i].getAnswerText());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (answers[choice - 1].getCorrectness()) {
            System.out.println("Correct!");
        } else {
            System.out.println("Helaas, dat is niet juist.");
        }

    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}