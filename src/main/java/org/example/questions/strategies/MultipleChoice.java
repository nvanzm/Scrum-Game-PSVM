package org.example.questions.strategies;

import org.example.questions.Question;
import org.example.questions.Answer;
import org.example.questions.QuestionBehavior;

import java.util.Scanner;

public class MultipleChoice implements QuestionBehavior {
    public void askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question.getQuestionText());

        Answer[] answers = question.getAnswers();

        for (int i = 0; i < answers.length; i++) {
            System.out.println((i + 1) + ". " + answers[i].getAnswerText());
        }

        int choice = scanner.nextInt();

        if (answers[choice - 1].getCorrectness()) {
            System.out.println("Correct!");
        } else {
            System.out.println("Helaas, dat is niet juist. Probeer het nog een keer!");
            askQuestion(question);
        }
    }
}
