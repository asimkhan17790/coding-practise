package com.algos.backtracking;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

// Write a recursive fùnction diceRol1 that accepts an integer
// representing a number of 6-sided dice to roll, and output all possible
// combinations of values that could appear on the dice.


// THIS WE ARE DOING USING BACKTRACKING
public class DiceRoll {
    public static void main(String[] args) {
        diceRoll(2);     
    }

    public static void diceRoll(int dice) {
        List<Integer> chosen = new LinkedList<>();
        diceRollHelper(dice, chosen);
    }
    public static void diceRollHelper(int dice, List<Integer> chosen){
        if (dice == 0){
            System.out.println(chosen);
        }else {
            for (int i = 1 ; i<=6 ; i++){
                chosen.add(i);
                int current = chosen.size()-1;
                diceRollHelper(dice-1, chosen);
                chosen.remove(current);
            }
        }
    }
}
