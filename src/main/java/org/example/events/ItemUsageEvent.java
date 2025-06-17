package org.example.events;

public class ItemUsageEvent extends GameEvent{
    private String itemName;

    public ItemUsageEvent(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
