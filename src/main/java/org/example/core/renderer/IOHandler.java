package org.example.core.renderer;

import java.util.List;

public interface IOHandler {
    void display(String message);
    void displayOptions(List<String> options);
    void displayOptionsNumbered(List<String> options);
    int getNumericInput();
    String getTextInput();
}