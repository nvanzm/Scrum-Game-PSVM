package org.example.core.renderer.output;

import org.example.menus.Menu;

public class MenuRenderer implements Renderer<Menu> {
    @Override
    public void render(Menu menu) {
        System.out.println("== " + menu.getRoomName() + " ==");
        System.out.println(menu.getWelcomeMessage());
    }
}
