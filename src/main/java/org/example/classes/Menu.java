package org.example.classes;

public abstract class Menu {
    public final void Display() {
        begroeting();
        optieMenu();
    }

    abstract void begroeting();
    abstract void optieMenu();
}

