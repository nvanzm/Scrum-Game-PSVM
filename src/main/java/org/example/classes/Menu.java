package org.example.classes;

public abstract class Menu {
    public final void display() {
        begroeting();
        optieMenu();
    }

    abstract void begroeting();
    abstract void optieMenu();
}

