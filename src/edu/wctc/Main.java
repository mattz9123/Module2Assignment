package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String roomInteract = "";
        String roomLoot = "";
        String roomExit = "";
        String roomEmpty = "";
        char choice1;

        Scanner keyboard = new Scanner(System.in);

//        System.out.println(Room.possibleDirections.add(Room.getAdjoiningRoom('n').toString()));

        Player player1 = new Player();

        EmptyRoom justAnEmptyRoom = new EmptyRoom(roomEmpty);

        InteractRoom roomToInteract = new InteractRoom(roomInteract);

        LootRoom roomToLoot = new LootRoom(roomLoot);

        ExitRoom roomToExit = new ExitRoom(roomExit);

        Maze smallMaze = new Maze(player1, justAnEmptyRoom, roomToInteract, roomToLoot, roomToExit);

        do {
            System.out.println(smallMaze.getCurrentRoomDescription());
            System.out.println("Please enter a direction (north, south, east, west, up, or down). You can also " +
                    "enter l (loot), i (interact), x (exit), or v (inventory)");
            choice1 = keyboard.nextLine().charAt(0);

            if (choice1 == 'n' || choice1 == 's' || choice1 == 'e' || choice1 == 'w'
                    || choice1 == 'u' || choice1 == 'd') {
                smallMaze.move(choice1);
            } else if (choice1 == 'l') {
                if (smallMaze.getCurrentRoomDescription().equals("This room is lootable")) {
                    System.out.println(roomToLoot.loot(player1));
                } else {
                    System.out.println("Nothing to loot in here");
                }

            } else if (choice1 == 'i') {

                if (smallMaze.getCurrentRoomDescription().equals("This room has a bag sitting in the middle (enter 'i' to interact).")) {
                    System.out.println(roomToInteract.interact(player1));
                } else {
                    System.out.println("Nothing to interact with in here");
                }

            System.out.println("You can go east to the empty room, north to the lootable room, or up to the exit room");

        }

            else if (choice1 == 'x') {
                if (smallMaze.getCurrentRoomDescription().equals("This room is exitable")){
                    roomToExit.exit(player1);
                    System.out.println(roomToExit.exit(player1));
                    System.out.println("Your score is " + Player.getScore());
                    smallMaze.isFinished = true;
            } else {
                    System.out.println("This room is not exitable");
                }
            }

            else if (choice1 == 'v') {

                System.out.println(player1.getInventory());
            }
            else {
                System.out.println("Not a valid direction");
            }

        } while (smallMaze.isFinished == false);
    }
}
