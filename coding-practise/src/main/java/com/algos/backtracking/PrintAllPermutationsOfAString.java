package com.algos.backtracking;

// BACKTRACKING BEST EXAMPLE
// Given a string. Print all the permutations of that string
public class PrintAllPermutationsOfAString {

    public static void main(String[] args) {
        
        String str = "abc";
        permute(str);

    }

    private static void permute(String str) {

        permuteHelper (str, "");

    }

    private static void permuteHelper (String str, String prefix) {

        // GOAL REACHED
        if (str.length() == 0) {
            System.out.println (prefix);             
        } else {
            // CHOICES LIST
            for (int i = 0; i < str.length(); i++) { 

                // MAKE CHOICES
                char chosenChar = str.charAt(i);
                String remainderString = str.substring(0, i) + str.substring(i+1);
                prefix += chosenChar;
                // CALL BACKTRACK RECURSION
                permuteHelper(remainderString, prefix);

                //UNDO CHOICES
                prefix = prefix.substring(0,prefix.length()-1);
            }
    
        }
    }
    
}
 