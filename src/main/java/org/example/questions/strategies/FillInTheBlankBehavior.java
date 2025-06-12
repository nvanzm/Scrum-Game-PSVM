package org.example.questions.strategies;

import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.AnswerValidator;
import org.example.questions.displays.FillInTheBlankDisplayStrategy;
import org.example.questions.displays.QuestionDisplayStrategy;

public class FillInTheBlankBehavior implements QuestionBehavior, AnswerValidator<String, String> {
    private final QuestionDisplayStrategy displayStrategy;
    private final IOHandler ioHandler;

    public FillInTheBlankBehavior(QuestionDisplayStrategy displayStrategy, IOHandler ioHandler) {
        this.displayStrategy = new FillInTheBlankDisplayStrategy();
        this.ioHandler = ioHandler;
    }


    @Override
    public void askQuestion(Question question) {
        displayStrategy.displayQuestion(question, ioHandler);

        String choice = ioHandler.getTextInput();
        String answer = question.getCorrectAnswerFITB();

        if (validateAnswer(answer, choice)){
            System.out.println("Correct!");
        }else{
            System.out.println("Helaas, dat is niet juist");
            askQuestion(question);
            //joker of item gebruiken
        }
    }

    @Override
    public boolean validateAnswer(String answer, String choice) {
        return choice.equalsIgnoreCase(answer);
    }
}
