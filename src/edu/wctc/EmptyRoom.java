package edu.wctc;

public class EmptyRoom extends Room {

    public EmptyRoom(String roomName) {
        super(roomName);
    }

    @Override
    public String getDescription() {
        return "Nothing in this room here. Nothing at all.";
    }
}
