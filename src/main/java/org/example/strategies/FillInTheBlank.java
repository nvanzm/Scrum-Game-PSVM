package org.example.strategies;

import org.example.Question;
import org.example.QuestionBehavior;

import java.util.Scanner;

public class FillInTheBlank implements QuestionBehavior {

    public void askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question.getQuestionText());

        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(question.getCorrectAnswerSingle())) {
            System.out.println("Correct!");
        } else {
            System.out.println("Helaas, dat is niet juist.");
        }
    }
}
