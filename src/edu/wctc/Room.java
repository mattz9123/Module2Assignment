package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private String name;
    private static Room north;
    private static Room south;
    private static Room east;
    private static Room west;
    private static Room up;
    private static Room down;
    public static List<String> possibleDirections;
    

    public Room(String roomName) {
        this.name = roomName;
    }

    public abstract String getDescription();

    public static Room getAdjoiningRoom(char direction){
        switch (direction){
            case 'n':
                return Room.north;
            case 's':
                return Room.south;
            case 'e':
                return Room.east;
            case 'w':
                return Room.west;
            case 'u':
                return Room.up;
            case 'd':
                return Room.down;
            default:
                return null;
        }
//        return Room;
    }
    public String getExits(){
        List<String> possibleDirections = new ArrayList<String>();
        if (getAdjoiningRoom('n') != null){
            possibleDirections.add(getAdjoiningRoom('n').toString());
        }
        if (getAdjoiningRoom('s') != null){
            possibleDirections.add(getAdjoiningRoom('s').toString());
        }
        if (getAdjoiningRoom('e') != null){
            possibleDirections.add(getAdjoiningRoom('e').toString());
        }
        if (getAdjoiningRoom('w') != null){
            possibleDirections.add(getAdjoiningRoom('w').toString());
        }
        if (getAdjoiningRoom('u') != null){
            possibleDirections.add(getAdjoiningRoom('u').toString());
        }
        if (getAdjoiningRoom('d') != null){
            possibleDirections.add(getAdjoiningRoom('d').toString());
        }
        return possibleDirections.toString();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        return true;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public Room getNorth() {
        return this.north;
    }

    public Room getSouth() {
        return this.south;
    }

    public Room getEast() {
        return this.east;
    }

    public Room getWest() {
        return this.west;
    }

    public Room getUp() {
        return this.up;
    }

    public Room getDown() {
        return this.down;
    }
}
