package com.algos.recursion;

// Write a recursive fùnction diceRol1 that accepts an integer
// representing a number of 6-sided dice to roll, and output all possible
// combinations of values that could appear on the dice.

// THIS ONE IS USING EXHHAUSTIVE SEARCH AND NO BACKTRACKING IS REQUIRED
public class DiceRoll {
    public static void main(String[] args) {
        diceRoll(2);     
    }

    public static void diceRoll(int dice) {
        diceRollHelper(dice, "{");
    }
    public static void diceRollHelper(int dice, String prefix){
        if (dice == 0){
            System.out.println(prefix + "}");
        }else {
            for (int i = 1 ; i<=6 ; i++){
                if (prefix.equals("{"))
                    diceRollHelper(dice-1, prefix + i);
            else 
                diceRollHelper(dice-1, prefix + "," + i);
            
            }
        }
    }
}
