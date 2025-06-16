import org.example.hints.HintSelector;
import org.example.questions.Question;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.junit.jupiter.api.Test;
import mocks.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Deze test controleert of het geven van een fout antwoord leidt tot het activeren van WrongAnswerHandler.
public class MultipleChoiceBehaviorTest {

    @Test
    public void testHintIsUsedOnWrongAnswer() {
        IOHandlerMock ioHandlerMock = new IOHandlerMock();
        HintProviderMock hintProviderMock = new HintProviderMock();
        HintSelector hintSelector = new HintSelector(List.of(hintProviderMock));
        OutcomeDisplayMock outcomeDisplay = new OutcomeDisplayMock();
        WrongAnswerHandlerMock mockWrongAnswerHandler = new WrongAnswerHandlerMock();

        MultipleChoiceBehavior behavior = new MultipleChoiceBehavior(
                ioHandlerMock,
                hintSelector,
                outcomeDisplay,
                mockWrongAnswerHandler
        );

        // Vraag met 2 antwoorden: juiste is op plek 2
        String[] antwoorden = {"Fout antwoord", "Goed antwoord"};
        Question question = new Question("Wat is 2+2?", antwoorden, 2, "4");

        // Act
        // Deze methode blijft normaal in een loop hangen, maar we geven 1 fout antwoord en laten hem daarna stoppen
        // Dus de mock IOHandler zorgt dat getNumericInput() altijd 1 geeft (fout antwoord)
        // En de mock WrongAnswerHandler zet een vlag zodat we weten dat hij is aangeroepen
        Thread testThread = new Thread(() -> {
            try {
                behavior.askQuestion(question);
            } catch (RuntimeException e) {
                // Verwachte uitzondering om uit de lus te breken
            }
        });
        testThread.start();

        try {
            Thread.sleep(100); // Laat de thread even lopen
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(mockWrongAnswerHandler.wasCalled);
    }
}
