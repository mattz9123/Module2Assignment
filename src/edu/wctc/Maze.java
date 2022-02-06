package edu.wctc;

public class Maze {
    private EmptyRoom emptyRoom;
    private InteractRoom iRoom;
    private LootRoom lRoom;
    private ExitRoom eRoom;
    private Room currentRoom;
    private Player player;
    public boolean isFinished = false;

    public Maze(Player player, EmptyRoom emroom, InteractRoom iroom, LootRoom lroom, ExitRoom eroom){
        this.player = player;
        this.iRoom = iroom;
        this.lRoom = lroom;
        this.eRoom = eroom;
        this.emptyRoom = emroom;
        this.emptyRoom.setWest(iRoom);
        this.iRoom.setNorth(lRoom);
        this.iRoom.setEast(emptyRoom);
        this.iRoom.setUp(eRoom);
        this.eRoom.setSouth(lRoom);
        this.lRoom.setSouth(iRoom);
        this.currentRoom = emptyRoom;
    }

    public String exitCurrentRoom(){
        if (currentRoom instanceof Exitable) {
            return ((Exitable) currentRoom).exit(player);
        }
        else {
            return "Room is not exitable";
        }
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        }
        else {
            return "Room is not interactable";
        }
    }

    public String LootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        }
        else {
            return "Room is not lootable";
        }
    }
    public boolean move(char direction) {
        if (direction == 'n') {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                return true;
            } else {
                return false;
            }
        } else if (direction == 's') {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                return true;
            } else {
                return false;
            }
        } else if (direction == 'e') {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                return true;
            } else {
                return false;
            }
        } else if (direction == 'w') {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                return true;
            } else {
                return false;
            }
        }
        else if (direction == 'u') {
            if (currentRoom.getUp() != null) {
                currentRoom = currentRoom.getUp();
                return true;
            } else {
                return false;
            }
        }
        else if (direction == 'd') {
            if (currentRoom.getDown() != null) {
                currentRoom = currentRoom.getDown();
                return true;
            } else {
                return false;
            }
        }
        else {
            System.out.println("Not a valid direction");
            return false;
        }
    }

    public int getPlayerScore() {
        return Player.getScore();
    }

    public String getPlayerInventory() {
        return Player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }
}