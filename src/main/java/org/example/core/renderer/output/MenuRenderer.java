package org.example.core.renderer.output;

import org.example.core.renderer.IOHandler;
import org.example.core.renderer.input.ConsoleIOHandler;
import org.example.menus.Menu;

import java.util.Arrays;

public class MenuRenderer implements Renderer<Menu> {
    IOHandler ioHandler;

    public MenuRenderer() {
        this.ioHandler = new ConsoleIOHandler();
    }
    @Override
    public void render(Menu menu) {
        ioHandler.display("== " + menu.getRoomName() + " ==");
        ioHandler.display(menu.getWelcomeMessage());

        ioHandler.displayOptionsNumbered(Arrays.asList(menu.getOptions()));
    }
}
