package edu.wctc;

public class ExitRoom extends Room implements Exitable{

    public ExitRoom(String roomName) {
        super(roomName);
    }

    @Override
    public String exit(Player obj) {
        return "You escaped the maze!";
    }

    @Override
    public String getDescription() {
        return "This room is exitable";
    }
}
