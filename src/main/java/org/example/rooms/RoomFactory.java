package org.example.rooms;

import org.example.core.renderer.IOHandler;
import org.example.hints.*;
import org.example.questions.QuestionBehavior;
import org.example.questions.displays.OutcomeDisplay;
import org.example.questions.strategies.FillInTheBlankBehavior;
import org.example.questions.strategies.MultipleChoiceBehavior;

import org.example.questions.strategies.PuzzleBehavior;
import org.example.questions.strategies.WrongAnswerHandler;
import org.example.rooms.templates.*;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory implements IRoomFactory {

    private final IOHandler ioHandler;
    private final OutcomeDisplay outcomeDisplay;
    private final WrongAnswerHandler wrongAnswerHandler;

    public RoomFactory(IOHandler ioHandler, OutcomeDisplay outcomeDisplay, WrongAnswerHandler wrongAnswerHandler) {
        this.ioHandler = ioHandler;
        this.outcomeDisplay = outcomeDisplay;
        this.wrongAnswerHandler = wrongAnswerHandler;
    }

    @Override
    public List<Room> createRooms() {

        QuestionBehavior multipleChoiceBehaviorPlanningRoom = new MultipleChoiceBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomPlanning(), new HelpHintRoomPlanning())), outcomeDisplay, wrongAnswerHandler);
        QuestionBehavior fillInTheBlankBehaviorDailyRoom = new FillInTheBlankBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomDaily(), new HelpHintRoomDaily())), outcomeDisplay, wrongAnswerHandler);
        QuestionBehavior multipleChoiceBehaviorBoardRoom = new MultipleChoiceBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomBoard(), new HelpHintRoomBoard())), outcomeDisplay, wrongAnswerHandler);
        QuestionBehavior fillInTheBlankBehaviorReviewRoom = new FillInTheBlankBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomReview(), new HelpHintRoomReview())), outcomeDisplay, wrongAnswerHandler);
        QuestionBehavior puzzleBehaviorRetroRoom = new PuzzleBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomRetro(), new HelpHintRoomRetro())), outcomeDisplay, wrongAnswerHandler);
        QuestionBehavior multipleChoiceBehaviorTiaRoom = new MultipleChoiceBehavior(ioHandler, new HintSelector(List.of(new FunnyHintRoomTia(), new HelpHintRoomTia())), outcomeDisplay, wrongAnswerHandler);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new RoomPlanning(multipleChoiceBehaviorPlanningRoom,"Planning Room", "Welcome to the Planning Room! Let's prepare for the next sprint."));
        rooms.add(new RoomDaily(fillInTheBlankBehaviorDailyRoom,"Daily Standup Room", "Welcome to the Daily Room! Time for your daily check-in."));
        rooms.add(new RoomBoard(multipleChoiceBehaviorBoardRoom, "Board Room", "This is the board room."));
        rooms.add(new RoomReview(fillInTheBlankBehaviorReviewRoom,"Review Room", "Welcome to the Review Room! Let's review what we've accomplished."));
        rooms.add(new RoomRetrospective(puzzleBehaviorRetroRoom,"Retrospective Room", "Welcome to the Retrospective Room! Let's reflect and improve."));
        rooms.add(new RoomTia(multipleChoiceBehaviorTiaRoom, "Tia's Room", "Welcome to Tia's room! Here you'll answer questions about Scrum."));
        return rooms;
    }
}