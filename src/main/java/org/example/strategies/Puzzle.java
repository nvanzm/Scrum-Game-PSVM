package org.example.strategies;

import org.example.classes.Question;
import org.example.interfaces.QuestionBehavior;

import java.util.Scanner;

public class Puzzle implements QuestionBehavior {

    public void askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question.getQuestionText());

        System.out.println("Probeer de termen en definities te koppelen:");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(question.getCorrectAnswerFromList())) {
            System.out.println("Correct!");
        } else {
            System.out.println("Helaas, dat is niet juist.");
        }
    }
}