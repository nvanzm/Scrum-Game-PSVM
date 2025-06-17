
package org.example.impediments.monster;


import java.util.Random;

public class EasyMathMonster extends Monster {
    private static final Random random = new Random();

    public EasyMathMonster() {
        super("Arithmetic Goblin", 1);
    }

    @Override
    protected void generateMathQuestion() {
        int a = random.nextInt(10) + 1; // 1-10
        int b = random.nextInt(10) + 1; // 1-10

        if (random.nextBoolean()) {
            // Addition
            this.mathQuestion = String.format("What is %d + %d?", a, b);
            this.correctAnswer = a + b;
        } else {
            // Subtraction (ensure positive result)
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            this.mathQuestion = String.format("What is %d - %d?", a, b);
            this.correctAnswer = a - b;
        }
    }


}