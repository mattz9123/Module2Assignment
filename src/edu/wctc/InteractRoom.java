package edu.wctc;

public class InteractRoom extends Room implements Interactable{
    public InteractRoom(String roomName) {
        super(roomName);
    }

    @Override
    public String interact(Player obj) {
        Player.addToScore(30);
        return "You opened the bag and find a bunch of points? + 30 points";

    }

    @Override
    public String getDescription() {
        return "This room has a bag sitting in the middle (enter 'i' to interact).";
    }
}
