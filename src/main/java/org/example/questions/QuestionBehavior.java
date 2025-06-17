package org.example.questions;

import org.example.events.GameEvent;

public interface QuestionBehavior {
    GameEvent askQuestion(Question question);
}