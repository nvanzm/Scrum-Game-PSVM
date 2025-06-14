package org.example.questions.strategies;

import org.example.questions.Question;
import org.example.questions.QuestionBehavior;

import java.util.Scanner;

public class FillInTheBlank implements QuestionBehavior {
    public String askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question.getQuestionText());

        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(question.getCorrectAnswerFITB())) {
            System.out.println("Correct!");
            return "ADVANCE_ROOM";
        } else {
            System.out.println("Helaas, dat is niet juist. Probeer het nog een keer!");
            askQuestion(question);
        }
        return "PLACEHOLDER";
    }
}
