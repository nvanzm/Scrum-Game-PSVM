import org.example.core.renderer.IOHandler;
import org.example.questions.Question;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stubs.IOHandlerStub;
import stubs.OutcomeDisplayMock;

import static org.junit.Assert.assertTrue;

public class OutcomeTest {


    @Test
    public void testDisplayCorrect() {
        //Test correct
        IOHandler ioHandler = new IOHandlerStub(
                java.util.List.of(1,2),
                java.util.List.of("1","2"));
        Question question = new Question("testtekst", new String[]{"ans", "ans2"}, 2, "bla");
        OutcomeDisplayMock outcomeDisplayMock = new OutcomeDisplayMock();
        MultipleChoiceBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler, outcomeDisplayMock);
        multipleChoiceBehavior.askQuestion(question);
        assertTrue(outcomeDisplayMock.displayedCorrect);
        assertTrue(outcomeDisplayMock.displayedIncorrect);
    }
}
