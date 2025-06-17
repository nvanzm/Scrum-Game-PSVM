package org.example.impediments.monster;

public abstract class Monster {
    protected String name;
    protected int difficulty;
    protected String mathQuestion;
    protected int correctAnswer;

    protected Monster(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        generateMathQuestion();
    }

    protected abstract void generateMathQuestion();


    public String getName() {
        return name;
    }

    public String getMathQuestion() {
        return mathQuestion;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}

