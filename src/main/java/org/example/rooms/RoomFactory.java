package org.example.rooms;

import org.example.core.renderer.IOHandler;
import org.example.questions.QuestionBehavior;
import org.example.questions.strategies.FillInTheBlank;
import org.example.questions.strategies.MultipleChoiceBehavior;
import org.example.rooms.templates.*;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory implements IRoomFactory {

    private final IOHandler ioHandler;

    public RoomFactory(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    @Override
    public List<Room> createRooms() {
        QuestionBehavior multipleChoiceBehavior = new MultipleChoiceBehavior(ioHandler);
        QuestionBehavior fillInTheBlank = new FillInTheBlank();

        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomPlanning(multipleChoiceBehavior,"Planning Room", "Welcome to the Planning Room! Let's prepare for the next sprint."));
        rooms.add(new RoomDaily(fillInTheBlank,"Daily Standup Room", "Welcome to the Daily Room! Time for your daily check-in."));
        rooms.add(new RoomBoard(multipleChoiceBehavior, "Board Room", "This is the board room."));
        rooms.add(new RoomReview(fillInTheBlank,"Review Room", "Welcome to the Review Room! Let's review what we've accomplished."));
        rooms.add(new RoomRetrospective(multipleChoiceBehavior,"Retrospective Room", "Welcome to the Retrospective Room! Let's reflect and improve."));
        rooms.add(new RoomTia(multipleChoiceBehavior, "Tia's Room", "Welcome to Tia's room! Here you'll answer questions about Scrum."));
        return rooms;
    }
}
