package org.example.rooms;

import org.example.Answer;
import org.example.Monster;
import org.example.Question;
import org.example.Room;

import java.util.Scanner;

public class RoomPlanning extends Room {
    private Question question;

    public RoomPlanning() {
        String[] answersTemp = {
                "Het team bepaalt hoeveel werk ze aankunnen",
                "Het team selecteert user stories uit de product backlog",
                "Het team splitst stories op in taken",
                "De Product Owner schrijft een uitgebreid eindrapport"
        };

        this.question = new Question("Welke taak hoort NIET thuis in de sprintplanning?", answersTemp);
    }

    public void handleQuestion() {
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
            System.out.println("Helaas, dat is niet juist.");
        }
    }

    @Override
    public void clearMonster() {

    }

    @Override
    public Monster getMonster() {
        return null;
    }
}
