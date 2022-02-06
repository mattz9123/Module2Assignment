package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int score;
    private static List<String> inventory = new ArrayList<>();


    public static void addToInventory(String item){
        inventory.add(item);
    }

    public static void addToScore(int points){
        score += points;
    }

    public static String getInventory(){
        if (inventory.isEmpty()){
            return "No items in inventory";
        } else{
            return inventory.toString();
        }
    }

    public static int getScore(){
        return score;
    }
}
