package org.example.core.renderer.output;

import org.example.menus.Menu;

public class MenuRenderer implements Renderer<Menu> {
    @Override
    public void render(Menu menu) {
        System.out.println("== " + menu.getRoomName() + " ==");
        System.out.println(menu.getWelcomeMessage());

        for (int i = 0; i < menu.getOptions().length; i++) {
            System.out.printf("%d. %s%n", i + 1, menu.getOptions()[i]);
        }
    }
}
