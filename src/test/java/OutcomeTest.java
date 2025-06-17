import org.example.core.renderer.IOHandler;
import org.example.hints.FunnyHintRoomPlanning;
import org.example.hints.HelpHintRoomPlanning;
import org.example.hints.HintSelector;
import org.example.questions.Question;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.questions.strategies.WrongAnswerHandler;
import org.junit.jupiter.api.Test;
import stubs.IOHandlerStub;
import mocks.OutcomeDisplayMock;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OutcomeTest {


    @Test
    public void testDisplayCorrect() {
        IOHandler ioHandler = new IOHandlerStub(
                java.util.List.of(2),
                java.util.List.of("Ja"));
        Question question = new Question("testtekst", new String[]{"ans", "ans2"}, 2, "bla");
        OutcomeDisplayMock outcomeDisplayMock = new OutcomeDisplayMock();
        WrongAnswerHandler wrongAnswerHandler = new WrongAnswerHandler();
        HintSelector hintSelector = new HintSelector(List.of(new FunnyHintRoomPlanning(), new HelpHintRoomPlanning()));
        MultipleChoiceBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler, hintSelector,outcomeDisplayMock, wrongAnswerHandler);
        multipleChoiceBehavior.askQuestion(question);
        assertTrue(outcomeDisplayMock.displayedCorrect);
    }

    @Test
    public void testDisplayIncorrect() {
        IOHandler ioHandler = new IOHandlerStub(
                java.util.List.of(1),
                java.util.List.of("Ja"));
        Question question = new Question("testtekst", new String[]{"ans", "ans2"}, 2, "bla");
        OutcomeDisplayMock outcomeDisplayMock = new OutcomeDisplayMock();
        WrongAnswerHandler wrongAnswerHandler = new WrongAnswerHandler();
        HintSelector hintSelector = new HintSelector(List.of(new FunnyHintRoomPlanning(), new HelpHintRoomPlanning()));
        MultipleChoiceBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler, hintSelector,outcomeDisplayMock, wrongAnswerHandler);
        multipleChoiceBehavior.askQuestion(question);
        assertTrue(outcomeDisplayMock.displayedIncorrect);
    }
}