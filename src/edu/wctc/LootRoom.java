package edu.wctc;

public class LootRoom extends Room implements Lootable{

    public LootRoom(String roomName) {
        super(roomName);
    }

    @Override
    public String loot(Player obj) {
        obj.addToInventory("bandages");
        return "Obtained bandages";
    }

    @Override
    public String getDescription() {
        return "This room is lootable";
    }
}
