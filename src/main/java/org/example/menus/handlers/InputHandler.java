package org.example.menus.handlers;

import org.example.events.GameEvent;

public interface InputHandler {
    GameEvent handleInput(String input);
}
