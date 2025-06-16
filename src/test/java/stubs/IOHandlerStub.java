package stubs;

import org.example.core.renderer.IOHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class IOHandlerStub implements IOHandler {

    private final List<String> displayedMessages = new ArrayList<>();
    private final List<List<String>> displayedOptions = new ArrayList<>();
    private final Queue<Integer> numericInputs = new LinkedList<>();
    private final Queue<String> textInputs = new LinkedList<>();

    // Constructor waarin je vooraf inputs kunt meegeven
    public IOHandlerStub(List<Integer> numericInputs, List<String> textInputs) {
        if (numericInputs != null) {
            this.numericInputs.addAll(numericInputs);
        }
        if (textInputs != null) {
            this.textInputs.addAll(textInputs);
        }
    }

    @Override
    public void display(String message) {
        displayedMessages.add(message);
    }

    @Override
    public void displayOptions(List<String> options) {
        displayedOptions.add(new ArrayList<>(options));
    }

    @Override
    public void displayOptionsNumbered(List<String> options) {

    }

    @Override
    public int getNumericInput() {
        return numericInputs.isEmpty() ? -1 : numericInputs.poll();
    }

    @Override
    public String getTextInput() {
        return textInputs.isEmpty() ? "" : textInputs.poll();
    }

    // Extra getters om te controleren wat er getoond is in tests
    public List<String> getDisplayedMessages() {
        return displayedMessages;
    }

    public List<List<String>> getDisplayedOptions() {
        return displayedOptions;
    }
}
