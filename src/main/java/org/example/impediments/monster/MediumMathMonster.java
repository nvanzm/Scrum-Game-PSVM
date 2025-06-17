
package org.example.impediments.monster;

import org.example.events.CorrectEvent;
import org.example.events.GameEvent;
import org.example.events.IncorrectAnswerEvent;

import java.util.Random;

public class MediumMathMonster extends Monster {
    private static final Random random = new Random();

    public MediumMathMonster() {
        super("Calculation Troll", 2);
    }

    @Override
    protected void generateMathQuestion() {
        int a = random.nextInt(50) + 10; // 10-59
        int b = random.nextInt(20) + 2;  // 2-21

        int operation = random.nextInt(3);
        switch (operation) {
            case 0 -> {
                // Addition
                this.mathQuestion = String.format("What is %d + %d?", a, b);
                this.correctAnswer = a + b;
            }
            case 1 -> {
                // Subtraction
                this.mathQuestion = String.format("What is %d - %d?", a, b);
                this.correctAnswer = a - b;
            }
            case 2 -> {
                // Multiplication (keep numbers small)
                a = random.nextInt(12) + 2; // 2-13
                b = random.nextInt(9) + 2;  // 2-10
                this.mathQuestion = String.format("What is %d × %d?", a, b);
                this.correctAnswer = a * b;
            }
        }
    }

}