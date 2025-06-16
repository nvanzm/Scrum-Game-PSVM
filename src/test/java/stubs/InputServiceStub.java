package stubs;

import org.example.core.renderer.input.InputService;

import java.util.LinkedList;
import java.util.Queue;

public class InputServiceStub extends InputService {
    private final Queue<String> inputs = new LinkedList<>();

    public InputServiceStub(String... inputs) {
        for (String input : inputs) {
            this.inputs.add(input);
        }
    }

    @Override
    public String readLine() {
        return inputs.isEmpty() ? "" : inputs.poll();
    }
}
