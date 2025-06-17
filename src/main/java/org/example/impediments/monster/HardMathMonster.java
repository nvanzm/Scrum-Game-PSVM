package org.example.impediments.monster;

import java.util.Random;

public class HardMathMonster extends Monster {
    private static final Random random = new Random();

    public HardMathMonster() {
        super("Mathematical Demon", 3);
    }

    @Override
    protected void generateMathQuestion() {
        int operation = random.nextInt(2);

        if (operation == 0) {
            // Complex multiplication
            int a = random.nextInt(25) + 15; // 15-39
            int b = random.nextInt(15) + 5;  // 5-19
            this.mathQuestion = String.format("What is %d × %d?", a, b);
            this.correctAnswer = a * b;
        } else {
            // Division (ensure clean division)
            int result = random.nextInt(50) + 10; // 10-59
            int divisor = random.nextInt(8) + 3;  // 3-10
            int dividend = result * divisor;
            this.mathQuestion = String.format("What is %d ÷ %d?", dividend, divisor);
            this.correctAnswer = result;
        }
    }


}