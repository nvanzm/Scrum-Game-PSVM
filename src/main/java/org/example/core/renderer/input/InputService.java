package org.example.core.renderer.input;

import java.util.Scanner;

public class InputService {
    private Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }
}