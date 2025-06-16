package mocks;

import org.example.core.renderer.IOHandler;

import java.util.List;

// Deze class puur aangemaakt voor MultipleChoiceBehaviorTest
public class IOHandlerMock implements IOHandler {

    @Override
    public int getNumericInput() {
        return 1; // Kies altijd een fout antwoord voor MultipleChoiceBehaviorTest
    }

    @Override
    public void display(String message) {

    }

    @Override
    public void displayOptions(List<String> options) {

    }

    @Override
    public void displayOptionsNumbered(List<String> options) {

    }

    @Override
    public String getTextInput() {
        return "";
    }
}
