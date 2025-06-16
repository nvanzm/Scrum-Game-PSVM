package org.example.rooms;

import org.example.core.renderer.IOHandler;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.strategies.FillInTheBlankBehavior;
import org.example.questions.strategies.MultipleChoiceBehavior;

import org.example.questions.strategies.PuzzleBehavior;
import org.example.rooms.templates.*;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory implements IRoomFactory {

    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;

    public RoomFactory(IOHandler ioHandler, OutcomeDisplay outcomeDisplay) {
        this.ioHandler = ioHandler;
        this.outcomeDisplay = outcomeDisplay;
    }

    @Override
    public List<Room> createRooms() {
        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler, outcomeDisplay);
        QuestionBehavior fillInTheBlankBehavior = new FillInTheBlankBehavior(ioHandler, outcomeDisplay);
        QuestionBehavior puzzleBehavior = new PuzzleBehavior(ioHandler, outcomeDisplay);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomPlanning(multipleChoiceBehavior,"Planning Room", "Welcome to the Planning Room! Let's prepare for the next sprint."));
        rooms.add(new RoomDaily(fillInTheBlankBehavior,"Daily Standup Room", "Welcome to the Daily Room! Time for your daily check-in."));
        rooms.add(new RoomBoard(multipleChoiceBehavior, "Board Room", "This is the board room."));
        rooms.add(new RoomReview(fillInTheBlankBehavior,"Review Room", "Welcome to the Review Room! Let's review what we've accomplished."));
        rooms.add(new RoomRetrospective(puzzleBehavior,"Retrospective Room", "Welcome to the Retrospective Room! Let's reflect and improve."));
        rooms.add(new RoomTia(multipleChoiceBehavior, "Tia's Room", "Welcome to Tia's room! Here you'll answer questions about Scrum."));
        return rooms;
    }
}